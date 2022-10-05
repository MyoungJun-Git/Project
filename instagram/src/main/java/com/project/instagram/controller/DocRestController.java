package com.project.instagram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocRestController {

    @GetMapping("/instagramAPI/main")
    public String test() {
        return "spring boot";
    }
}