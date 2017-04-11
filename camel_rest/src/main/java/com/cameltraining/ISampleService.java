package com.cameltraining;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 * Created by Lenovo on 4/11/2017.
 */
@Path("/greeting")
@Consumes(value = "application/xml,application/json")
@Produces(value = "application/xml,application/json")
public interface ISampleService {
    @GET
    @Path("/hello/{name}")
    ServiceResponse greet(@PathParam("name") String name);
}
