package com.cameltraining.converter;

/**
 * Created by Lenovo on 4/13/2017.
 */
public class MyCustomObject {
    String name;
    int age;
    String message;

    public MyCustomObject(String name, int age, String message) {
        this.name = name;
        this.age = age;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
