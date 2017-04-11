package com.cameltraining;


import org.apache.camel.Exchange;


/**
 * Created by Lenovo on 4/11/2017.
 */
public class ConsoleWriter {
    public void writeToConsole(Exchange exchange)
    {
        System.out.println("Exchange received");
    }
}
