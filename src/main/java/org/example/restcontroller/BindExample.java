package org.example.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bind")
public class BindExample {

    @GetMapping
    public String printName(@RequestParam(required = false) String name) {
        return name != null ? "Hello " + name : "Please provide name please :D";
    }

    @GetMapping("/default")
    public String printNameOrDefault(@RequestParam(defaultValue = "set name please :D") String name) {
        return "Hello " + name;
    }

    @GetMapping("/{someNumber}")
    public String passNumberWithPath(@PathVariable int someNumber) {
        return "Your number " + someNumber;
    }
}
