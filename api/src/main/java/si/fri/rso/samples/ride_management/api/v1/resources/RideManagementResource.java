package si.fri.rso.samples.ride_management.api.v1.resources;

import com.kumuluz.ee.logs.cdi.Log;
import si.fri.rso.samples.ride_management.services.beans.RideManagementBean;
import si.fri.rso.samples.ride_management.services.configuration.AppProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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

    @GET
    public Response test() {

//        List<Review> reviews = rideManagementBean.getRideManagement();
//
        return Response.ok().build();
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
