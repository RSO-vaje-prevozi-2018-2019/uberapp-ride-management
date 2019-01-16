package si.fri.rso.samples.ride_management.services.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import si.fri.rso.samples.ride_management.models.dtos.Notification;
import si.fri.rso.samples.ride_management.models.dtos.PickupPoint;
import si.fri.rso.samples.ride_management.models.dtos.Ride;
import si.fri.rso.samples.ride_management.models.dtos.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.InternalServerErrorException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class ExternalBean {

    private ObjectMapper objectMapper;

    private static final String RAPID_API_KEY = "53843e26f3msh519f666d6bbc58fp1ae853jsn8330a2192e68";

    @PostConstruct
    private void init() {
        objectMapper = new ObjectMapper();
    }

//    @Inject
//    @DiscoverService(value = "uberapp-notifications")
//    private Optional<String> basePathNotifications;
//
    @Inject
    @DiscoverService(value = "uberapp-rides")
    private Optional<String> basePathRides;

    public Ride getRide(int rideId) {

        String url = "";
        if (basePathRides.isPresent()) {
            url = basePathRides.get() + "/v1/rides/"+ rideId;
        } else {
            throw new InternalServerErrorException("ni urlja");
        }
        System.out.println("url je podan, celoten: " + url);
        String json = getJSONResponse(url, new ArrayList<>());

        System.out.println("dobljeni json" + json);

        Ride drive = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            drive = mapper.readValue(json, Ride.class);
        } catch (IOException e) {
            //logiranje
            System.out.println("request: getRide, error: " + e);
        }
        System.out.println("vračam driv: " + drive);
        return drive;

    }

    public PickupPoint getClosestCity(double latitude, double longitude){

        String url = "https://geocodeapi.p.rapidapi.com/GetNearestCities";
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("latitude", Double.toString(latitude)));
        params.add(new BasicNameValuePair("longitude", Double.toString(longitude)));
        params.add(new BasicNameValuePair("range", "0"));
        String json = getJSONResponse(url ,params);

        List<PickupPoint> cities = new ArrayList<>();
        try {
//            cities = objectMapper.readValue(json, PickupPoint.class);
            cities = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, PickupPoint.class));
        } catch (Exception e) {
            System.out.println(e);
        }

        if (cities.size() >= 1) {
            return cities.get(0);
        } else {
            return new PickupPoint();
        }
    }

    private static String getJSONResponse(String fullUrl, List<NameValuePair> params) {
        try {

            HttpClient httpClient = HttpClientBuilder.create().build();
            URIBuilder builder = new URIBuilder(fullUrl);
            builder.setParameters(params);
            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("X-RapidAPI-Key", RAPID_API_KEY );
            HttpResponse  response = httpClient.execute(request);

            int status = response.getStatusLine().getStatusCode();
            System.out.println("response code: " + status);
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                if (entity != null)
                    return EntityUtils.toString(entity);
            } else {
                String msg = "Remote server '" + fullUrl + "' is responded with status " + status + ".";
                System.out.println(msg);
                // todo logging
                throw new InternalServerErrorException(msg);
            }

        } catch (Exception e) {
            String msg = e.getClass().getName() + " occured: " + e.getMessage();
            // todo logging
            System.out.println(msg);
            throw new InternalServerErrorException(msg);
        }
        return "{}"; //empty json
    }

//    private List<AccountOptions> getObjects(String json) throws IOException {
//        return json == null ? new ArrayList<>() : objectMapper.readValue(json,
//                objectMapper.getTypeFactory().constructCollectionType(List.class, AccountOptions.class));
//    }
}
