package com.example;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.model.PactFragment;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by rashmi.patil on 19/09/16.
 */
public class Service3PactTests extends ConsumerPactTest{
    @Override
    protected PactFragment createFragment(ConsumerPactBuilder.PactDslWithProvider builder) {
        return builder
                .uponReceiving("Request for Service 3")
                .path("/service3")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("Hello from service 3")
                .toFragment();    }

    @Override
    protected String providerName() {
        return "Service 3";
    }

    @Override
    protected String consumerName() {
        return "Service 1";
    }

    @Override
    protected void runTest(String url) throws IOException {
        Service2Client client = new Service2Client(url);
        String response = client.callService2("/service3");
        assertEquals("Hello from service 3", response);
    }

}
