package com.cameltraining.aggragatesample;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Lenovo on 4/13/2017.
 */
@Path("userservice")
public interface UserService
{
    @Path("user/{name}/{sequence}/{msg}")
    String userData(@PathParam("user")String user ,
                    @PathParam("sequence") int sequence, @PathParam("msg")String msg);
}
