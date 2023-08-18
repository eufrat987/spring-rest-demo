package org.example.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloWorld {
    @GetMapping
    public String getHello() {
        return "Hello world";
    }

    @GetMapping("/v2")
    public String getHello2() {
        return "Hello world 2";
    }
}
