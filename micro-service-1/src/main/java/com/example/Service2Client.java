package com.example;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by rashmi.patil on 19/09/16.
 */


public class Service2Client {

    private String baseUrl;

    public Service2Client(){};

    public Service2Client(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String callService2(String serviceEndPint) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(baseUrl + serviceEndPint, String.class);
        return  response;
    }
}
