package com.cameltraining.soapservice;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Lenovo on 4/24/2017.
 */
public class GreetServiceBean implements Processor{
    public void process(Exchange exchange) throws Exception
    {
        GreetRequest request = exchange.getIn().getBody(GreetRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setError("NoError");
        apiResponse.setErrorCode(0);
        apiResponse.setResultMessage(String.format("Hello %s your age is %d", request.getName() , request.getAge()));
        exchange.getIn().setBody(apiResponse);
    }
}
