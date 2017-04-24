package com.cameltraining.soapservice;

/**
 * Created by Lenovo on 4/24/2017.
 */
public class GreetRequest {
    String name;
    int age;

    public GreetRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
