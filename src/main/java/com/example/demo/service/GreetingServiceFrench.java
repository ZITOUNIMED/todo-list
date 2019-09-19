package com.example.demo.service;

import com.example.demo.annotation.FrLanguage;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@FrLanguage
public class GreetingServiceFrench implements GreetingService{
    @Override
    public String getGreetingMessage() {
        return "Bonjour tout le monde!";
    }
}
