package com.cameltraining.aggragatesample;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Lenovo on 4/11/2017.
 */
@Path("/greeting")
public interface ISampleService {
    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    String greet(@PathParam("name") String name);
}
