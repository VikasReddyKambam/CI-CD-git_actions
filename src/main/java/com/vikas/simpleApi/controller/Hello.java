package com.vikas.simpleApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello(){
        return "Hello from vikas";
    }

    @PostMapping("/id/{id}")
    public int id(@PathVariable int id){
        return id;
    }
}
