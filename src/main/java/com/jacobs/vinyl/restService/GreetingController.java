package com.jacobs.vinyl.restService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    //@CrossOrigin
    @GetMapping("/greeting")
    public Greeting greeting() {
        System.out.println("In greeting");
        return new Greeting("IT WORKED");
    }
}
