package com.example.demo.service.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedService {
    private static int createdBeansCount = 0;
    private static int destroyedBeansCount = 0;
    @PostConstruct
    private void setUp(){
        createdBeansCount++;
    }

    public String doSomething(){
        return "createdBeansCount: " + createdBeansCount + ", destroyedBeansCount: " + destroyedBeansCount;
    }

    @PreDestroy
    private void cleanUp(){
        destroyedBeansCount++;
    }
}
