package com.cameltraining.soapservice;

import javax.jws.WebService;

/**
 * Created by Lenovo on 4/24/2017.
 */
@WebService
public interface IGreetService {
    String sayHello(String name);
}
