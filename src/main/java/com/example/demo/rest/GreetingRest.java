package com.example.demo.rest;

import com.example.demo.annotation.EngLanguage;
import com.example.demo.annotation.FrLanguage;
import com.example.demo.service.GreetingService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("greeting")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GreetingRest {
    @Inject
    @EngLanguage
    private GreetingService greetingServiceEng;

    @Inject
    @FrLanguage
    private GreetingService greetingServiceFr;

    @Path("message/{lang}")
    @GET
    public String getGreetingMessage(@PathParam("lang") String lang){
        if("fr".equals(lang)){
            return greetingServiceFr.getGreetingMessage();
        }
        return greetingServiceEng.getGreetingMessage();
    }
}
