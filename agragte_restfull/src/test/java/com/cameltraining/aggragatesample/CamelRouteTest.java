package com.cameltraining.aggragatesample;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 4/13/2017.
 */
public class CamelRouteTest extends CamelBlueprintTestSupport {
    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/blueprint.xml";
    }

    private static final String URL = "http://localhost/8484/userservice/user";

//    protected static UserService createCXFClient() {
//        // we use CXF to create a client for us as its easier than JAXWS and works
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        factory.setServiceClass(UserService.class);
//        factory.setAddress(URL);
//        return (UserService) factory.create();
//    }

    @Test
    public void testNothing()
    {

//        String response = template.requestBodyAndHeader("restlet:http://localhost/8484/?restletMethod=GET",
//                null, "Accept", "application/json",
//                String.class);
//        getMockEndpoint("mock:userService").expectedMessageCount(1);
        //assertMockEndpointsSatisfied();
    }
}