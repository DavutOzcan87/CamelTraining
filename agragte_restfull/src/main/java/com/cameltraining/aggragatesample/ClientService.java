package com.cameltraining.aggragatesample;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Lenovo on 4/12/2017.
 */
@Consumes(value = "application/json")
@Produces(value = "application/xml,application/json")
public interface ClientService {

    @GET
    @Path("/ping/{msg}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String ping(@PathParam("msg") String msg);
//    {
//        System.out.println("--Ping method--");
//        if(response != null)
//            print(response);
//    }
//
//    private void print(ClientResponse response) {
//        System.out.println("Response recevied");
//        System.out.println("Status :"+response.getStatus());
//    }
}
