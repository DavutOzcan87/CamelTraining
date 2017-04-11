package com.cameltraining;

import static com.cameltraining.ServiceResponse.of;

/**
 * Created by Lenovo on 4/11/2017.
 */
public class SampleServiceImp implements ISampleService{
    public SampleServiceImp() {
    }

    public ServiceResponse greet(String name) {
        String result = "Hello "+name;
        System.out.println("greet:"+result);
        return of(result);
    }
}
