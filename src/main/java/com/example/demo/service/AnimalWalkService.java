package com.example.demo.service;

import com.example.demo.annotation.AnimalMoveQualifier;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@AnimalMoveQualifier(value =  AnimalMoveQualifier.AnimalMoveType.WALK)
public class AnimalWalkService implements AnimalMoveService {
    @Override
    public String move() {
        return "I'm walking";
    }
}
