package com.cameltraining.aggragatesample;

import org.apache.camel.Endpoint;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 4/21/2017.
 */
public class AggregateRouteTests extends CamelBlueprintTestSupport {

    private RouteDefinition routeDefinition;

    @Override
    protected String getBlueprintDescriptor() {
        return InboundRouteTest.BLUEPRINT_XML_FILE;
    }

    @Override
    public boolean isUseAdviceWith() {
        return true;
    }

    @Before
    public void before() {
        this.routeDefinition = context.getRouteDefinition("aggragate-route");
    }

    @Test
    public void shouldAggregateByCount() throws Exception {
        final String mockAggregated = "mock:aggreagated";
        routeDefinition.adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("direct:start");
                weaveById("aggregatedMessageEndpointID")
                        .replace()
                        .to(mockAggregated);
            }
        });
        endPointOf(mockAggregated).expectedBodiesReceived("m1");
        String uniqueID = System.currentTimeMillis()+"";
        Map<String , Object> map = new HashMap<String,Object>();
        map.put(UserServiceRequestNormalizer.COMPLETION_SIZE , 1);
        map.put(UserServiceRequestNormalizer.CORRELATION_ID , uniqueID);
        template.sendBodyAndHeaders( "direct:start", "m1",map);
        assertMockEndpointsSatisfied();
    }


    @Test
    public void shouldAggregateItselfWhenCompletionSizeIsONE()
    {

    }
    private MockEndpoint endPointOf(String uri) {
        MockEndpoint me = getMockEndpoint(uri);
        return me;
    }
}
