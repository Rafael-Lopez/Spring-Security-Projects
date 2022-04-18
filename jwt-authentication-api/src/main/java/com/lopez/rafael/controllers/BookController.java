package com.lopez.rafael.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @GetMapping("/books")
    public String getBooks() {
        return "Some books...";
    }
}