package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rashmi.patil on 19/09/16.
 */

@RestController
public class MicroController1 {

    @RequestMapping("/service1")
    public String service2(){
        Service2Client client = new Service2Client("http://localhost:9002");
        String response = client.callService2("/service2");
        return "service2: "+response;
    }

    @RequestMapping("/service1/service3")
    public String service23(){
        Service2Client client = new Service2Client("http://localhost:9002");
        String response1 = client.callService2("/service2");

        String response2 = client.callService2("/service3");
        return response1+"\n"+response2;
    }
}
