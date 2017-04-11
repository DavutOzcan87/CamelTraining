package com.cameltraining;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

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
