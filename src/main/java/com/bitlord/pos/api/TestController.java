package com.bitlord.pos.api;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/v1/test" )
public class TestController {

    @Value( "${server.port}" )
    int portNumber;

    @Value( "${spring.application.name}" )
    String applicationName;

    @GetMapping( "/process" )// localhost:8001/api/v1/test/process
    public String test(){
        return applicationName + " started and running on port " + portNumber;
    }

}
