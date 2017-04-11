package com.cameltraining;

/**
 * Created by Lenovo on 4/11/2017.
 */
public class SampleServiceImp implements ISampleService{

    public String greet(String name) {
        return "Hello "+name;
    }
}
