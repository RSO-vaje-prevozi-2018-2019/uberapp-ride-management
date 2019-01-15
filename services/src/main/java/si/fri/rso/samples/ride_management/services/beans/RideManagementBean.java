package si.fri.rso.samples.ride_management.services.beans;

import si.fri.rso.samples.ride_management.models.dtos.User;
import si.fri.rso.samples.ride_management.services.configuration.AppProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.List;


@RequestScoped
public class RideManagementBean {

//    private Logger log = Logger.getLogger(RideManagementBean.class.getName());


    @Inject
    private AppProperties appProperties;

    @Inject
    private RideManagementBean rideManagementBean;

    @Inject
    private ExternalBean externalBean;

    private Client httpClient;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
//        baseUrl = "http://localhost:8081"; // only for demonstration
    }




}
