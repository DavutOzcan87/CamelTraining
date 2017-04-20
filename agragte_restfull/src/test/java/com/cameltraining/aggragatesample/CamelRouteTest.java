package com.cameltraining.aggragatesample;

import org.apache.camel.builder.AdviceWithRouteBuilder;
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


    @Override
    public boolean isUseAdviceWith() {
        return true;
    }

    private static final String URL = "http://localhost/8484/userservice/user";

    @Test
    public void testNothing() throws Exception {
        context.getRouteDefinition("inbound-route").adviceWith(context, new AdviceWithRouteBuilder()
        {
            @Override
            public void configure() throws Exception
            {
                replaceFromWith("direct:start");
            }
        });
        context.start();
        template.sendBody("direct:start","test");
    }
}