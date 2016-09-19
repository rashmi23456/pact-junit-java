package com.example;

import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.consumer.ConsumerPactBuilder.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by rashmi.patil on 19/09/16.
 */
public class Service2PactTests extends ConsumerPactTest{
    @Override
    protected PactFragment createFragment(PactDslWithProvider builder) {
        return builder
                .uponReceiving("Request for Service 2")
                .path("/service2")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body("Hello from service 2")
                .toFragment();    }

    @Override
    protected String providerName() {
        return "Service 2";
    }

    @Override
    protected String consumerName() {
        return "Service 1";
    }

    @Override
    protected void runTest(String url) throws IOException {
        Service2Client client = new Service2Client(url);
        String response = client.callService2("/service2");
        assertEquals("Hello from service 2", response);
    }

}
