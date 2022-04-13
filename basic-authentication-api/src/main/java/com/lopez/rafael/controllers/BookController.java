package com.lopez.rafael.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @GetMapping(value = "/books")
    public String getBooks() {
        return "Some books...";
    }
}