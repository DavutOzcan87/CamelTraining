package com.cameltraining.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by davut on 13.04.2017.
 */
@Path(value="/")
public interface Freegeoip {
    @GET
    @Path(value="/{type}/{ip}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String getGeoip(@PathParam("type") String type, @PathParam("ip") String ip);
}
