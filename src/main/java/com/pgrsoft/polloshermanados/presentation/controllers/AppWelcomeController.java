package com.pgrsoft.polloshermanados.presentation.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppWelcomeController {

    @GetMapping("/app")
    public String main() {
        return "welcome"; 
    }
    
}
