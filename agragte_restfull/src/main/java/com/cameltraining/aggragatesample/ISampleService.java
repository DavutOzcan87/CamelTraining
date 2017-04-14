package com.cameltraining.aggragatesample;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Lenovo on 4/11/2017.
 */
public interface ISampleService {
    @GET
    @Path("/user/{name}/{count}/{message}")
    @Produces(MediaType.TEXT_PLAIN)
    String greet(
            @PathParam("name") String name,
            @PathParam("count") String count,
            @PathParam("message") String message
    );
}
