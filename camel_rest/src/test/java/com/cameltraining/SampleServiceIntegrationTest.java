package com.cameltraining;

import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Lenovo on 4/11/2017.
 */
public class SampleServiceIntegrationTest {
//    @Override
//    protected String getBlueprintDescriptor() {
//        return "OSGI-INF/blueprint/blueprint.xml";
//    }

    @Test
    public void shouldGreet()
    {
        String response = new WebClient()
                .url("http://localhost:8383/greeting/hello/test")
                .call()
                .body();
        assertThat(response , is("Hello test"));
    }
}