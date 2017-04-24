package com.cameltraining.soapservice;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Lenovo on 4/24/2017.
 */
@WebService
public interface IGreetService {
    @WebResult(name = "greet_response")
    ApiResponse sayHello(@WebParam(name = "greet_request") GreetRequest request);
}
