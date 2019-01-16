package si.fri.rso.samples.ride_management.api.v1.resources;

import com.kumuluz.ee.configuration.cdi.ConfigValue;
import com.kumuluz.ee.logs.cdi.Log;
import si.fri.rso.samples.ride_management.models.dtos.PickupPoint;
import si.fri.rso.samples.ride_management.models.dtos.Ride;
import si.fri.rso.samples.ride_management.services.beans.ExternalBean;
import si.fri.rso.samples.ride_management.services.beans.RideManagementBean;
import si.fri.rso.samples.ride_management.services.configuration.AppProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Path("ride_management")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Log
public class RideManagementResource {

    private Logger log = Logger.getLogger(RideManagementResource.class.getName());

    @Inject
    private AppProperties appProperties;

    @Inject
    private RideManagementBean rideManagementBean;

    @Context
    protected UriInfo uriInfo;

    @Inject
    private ExternalBean externalBean;


    @GET
    @Path("hardcode")
    public Response test() {

        PickupPoint point = externalBean.getClosestCity(46.148822, 14.986707);

        return Response.ok().entity(point).build();
    }

    @GET
    @Path("findClosestCity/{lat}/{lon}")
    public Response findClosestCity(@PathParam("lat") BigDecimal lat, @PathParam("lon") BigDecimal lon) {

        PickupPoint point = externalBean.getClosestCity(lat.doubleValue(), lon.doubleValue());

        return Response.ok().entity(point).build();
    }

    @GET
    @Path("findClosestCityRide/{rideId}")
    public Response findClosestCityRide(@PathParam("rideId") Integer rideId) {

//        List<Review> reviews = rideManagementBean.getRideManagement();

        Ride ride = externalBean.getRide(rideId);
        double latitude = ride.getInitialLatitute();
        double longitude = ride.getInitialLongitude();
        PickupPoint point = externalBean.getClosestCity(latitude, longitude);
//
        return Response.ok().entity(point).build();
    }


    @GET
    @Path("/{reviewId}")
    public Response getReview(@PathParam("reviewId") Integer reviewId) {

//        Review review = rideManagementBean.getReview(reviewId);
//
//        if (review == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//
        return Response.status(Response.Status.OK).build();
//        return Response.status(Response.Status.OK).entity(review).build();
    }

//    @POST
//    @Path("create")
//    public Response createReview(RideManagement review) {
//
////        if (review.getAuthorId() == null || review.getRating() == null || review.getReview() == null || review.getRideId() == null) {
////            return Response.status(Response.Status.BAD_REQUEST).build();
////        }
////
////        Review newReview = rideManagementBean.createReview(review);
////
////        if (newReview != null && newReview.getId() != null) {
////            return Response.status(Response.Status.CREATED).entity(newReview).build();
////        } else {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
////        }

//    }





}
