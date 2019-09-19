package com.example.demo.service;

import com.example.demo.annotation.EngLanguage;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@EngLanguage
@RequestScoped
public class GreetingServiceEnglish implements GreetingService{
//    @Inject
//    private Logger logger;
    private String greeting;

    @PostConstruct
    private void init(){
        //logger.info("Init GreetingService ....");
        greeting = "Hello world!";
    }

    @Override
    public String getGreetingMessage(){
        return greeting;
    }

    @PreDestroy
    private void kill(){
//        logger.info("Kill GreetingService ...");
        greeting = null;
    }
}
