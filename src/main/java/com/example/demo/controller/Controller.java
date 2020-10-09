package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<Map> defaultMapping(){
        var response = new HashMap<>();
        response.put("Message","Hello there!");
        return ResponseEntity.ok(response);
    }
}
