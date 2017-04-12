package com.cameltraining.restclient;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by davut on 12.04.2017.
 */
@Path("/camelmocksrvice")
@Consumes({"application/xml,application/json"})
@Produces({"application/xml,application/json"})
public interface GreetingService {
    @GET
    @Path("/greet")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response greet(org.apache.camel.impl.DefaultMessage arg);
}
