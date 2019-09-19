package com.example.demo.rest.scope;

import com.example.demo.service.scope.ApplicationScopedService;
import com.example.demo.service.scope.ConversationScopedService;
import com.example.demo.service.scope.RequestScopedService;
import com.example.demo.service.scope.SessionScopedService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("scope")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScopeRest {
    @Inject
    private RequestScopedService requestScopedService;

    @Inject
    private SessionScopedService sessionScopedService;

    @Inject
    private ApplicationScopedService applicationScopedService;

    @Inject
    private ConversationScopedService conversationScopedService;

    @Path("{type}")
    @GET
    public String doSomething(@PathParam("type") String type){
        if("session".equals(type)){
            return sessionScopedService.doSomething();
        } else if("application".equals(type)){
            return applicationScopedService.doSomething();
        } else if("conversation".equals(type)){
            return conversationScopedService.doSomething();
        }
        return requestScopedService.doSomething();
    }
}
