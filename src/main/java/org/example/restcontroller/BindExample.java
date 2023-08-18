package org.example.restcontroller;

import org.example.dto.SomeData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/someData")
    @ResponseStatus(HttpStatus.OK)
    public String passObj(@RequestBody SomeData someData) {
        if (someData.name() == null) {
            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "Provide name please",
                    new IllegalArgumentException()
            );
        }
        return "Your data " + someData;
    }
}
