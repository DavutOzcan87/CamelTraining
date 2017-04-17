package com.cameltraining.aggragatesample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Created by Lenovo on 4/17/2017.
 */
public interface IMessagingService {
    @GET
    @Path("/messageservice/{userid}")
    @Produces(MediaType.TEXT_PLAIN)
    String message(@PathParam("userid") String userid);
}
