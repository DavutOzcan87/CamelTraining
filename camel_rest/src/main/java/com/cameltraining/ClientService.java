package com.cameltraining;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 * Created by Lenovo on 4/12/2017.
 */
@Consumes(value = "application/xml,application/json")
@Produces(value = "application/xml,application/json")
public interface ClientService {

    @GET
    @Path("/ping")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void ping(ClientResponse response);
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
