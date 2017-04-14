package com.cameltraining.aggragatesample;

import java.io.Serializable;

/**
 * Created by Lenovo on 4/14/2017.
 */
public class UserData implements Serializable {
    String name;
    int sequence;
    String message;

    public UserData(String name, int sequence, String message) {
        this.name = name;
        this.sequence = sequence;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return String.format("[%s:%s %d %s]",getClass().getSimpleName() , getName() , getSequence() , getMessage());
    }
}
