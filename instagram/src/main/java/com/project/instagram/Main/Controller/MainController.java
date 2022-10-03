package com.project.instagram.Main.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/instagramAPI/main")
    public String test() {
        return "spring boot";
    }
}
