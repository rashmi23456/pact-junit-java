package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rashmi.patil on 19/09/16.
 */

@RestController
public class MicroController2 {

    @RequestMapping("/service2")
    public String service2(){
        String response = "Hello from service 2";
        return response;
    }

    @RequestMapping("/service3")
    public String service3(){
        return  "Hello from service 3";
    }
}
