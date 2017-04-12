package com.cameltraining;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 * Created by Lenovo on 4/12/2017.
 */
@Consumes(value = "application/json")
//@Produces(value = "application/xml,application/json")
public interface ClientService {

    @GET
    @Path("/ping/{msg}")
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public ClientResponse ping(@PathParam("msg") String msg);
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
