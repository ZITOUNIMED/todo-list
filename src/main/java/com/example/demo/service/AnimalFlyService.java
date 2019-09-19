package com.example.demo.service;

import com.example.demo.annotation.AnimalMoveQualifier;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@AnimalMoveQualifier(value =  AnimalMoveQualifier.AnimalMoveType.FLY)
public class AnimalFlyService implements AnimalMoveService {
    @Override
    public String move() {
        return "I'm flying";
    }
}
