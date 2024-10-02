package com.amey.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String greet(HttpServletRequest request){
        return "Hello World: "+request.getSession().getId();
    }
    @GetMapping("about")
    public String about() {
        return "Amey";
    }
}
