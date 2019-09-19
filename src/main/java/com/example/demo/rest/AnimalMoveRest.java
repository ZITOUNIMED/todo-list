package com.example.demo.rest;

import com.example.demo.annotation.AnimalMoveQualifier;
import com.example.demo.service.AnimalMoveService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("animal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnimalMoveRest {
    @Inject
    @AnimalMoveQualifier(value =  AnimalMoveQualifier.AnimalMoveType.FLY)
    private AnimalMoveService animalFlyService;

    @Inject
    @AnimalMoveQualifier(value =  AnimalMoveQualifier.AnimalMoveType.WALK)
    private AnimalMoveService animalWalkService;

    @Path("move/{type}")
    @GET
    public String animalMove(@PathParam("type") String type){
        if("fly".equals(type)){
            return animalFlyService.move();
        }
        return animalWalkService.move();
    }
}
