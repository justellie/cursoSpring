package com.ellie.restdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final Greeting greeting;

    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }


    @GetMapping
    public String getName() {
        return this.greeting.getName();
    }

    @GetMapping("/coffee")
    public String getCoffee(){
        return this.greeting.getCoffee();
    }

}
