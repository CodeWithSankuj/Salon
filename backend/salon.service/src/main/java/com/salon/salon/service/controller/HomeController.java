package com.salon.salon.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String Index(){
        return "Home Controller from Salon Service";
    }
}
