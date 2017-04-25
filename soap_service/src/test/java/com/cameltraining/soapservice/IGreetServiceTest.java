package com.cameltraining.soapservice;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 4/24/2017.
 */
public class IGreetServiceTest extends CamelBlueprintTestSupport{
    private static final String ANY_NAME = "test user";
    private static final int ANY_AGE = 10;

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/blueprint.xml";
    }

    @Override
    public boolean isUseAdviceWith() {
        return true;
    }

    @Test
    public void shouldCallWebService() throws Exception {
        context.start();
        GreetRequest request = new GreetRequest();
        request.setName(ANY_NAME);
        request.setAge(ANY_AGE);
        List<Object> params = new ArrayList<Object>();
        ApiResponse response =  template.requestBody("cxf:bean:greetServiceEndpoint" , request , ApiResponse.class);
        assertNotNull(response);
    }
}