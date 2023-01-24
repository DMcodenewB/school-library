package com.example.schoollibrary.controllers;

import com.example.schoollibrary.entities.Ksiazka;
import com.example.schoollibrary.services.KsiazkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ksiazka")
public class KsiazkaController {

    @Autowired
    KsiazkaService ksiazkaService;

    @GetMapping("")
    public List<Ksiazka> getAllBooks(){
        return ksiazkaService.getAll();
    }

    @GetMapping("/search")
    public List<Ksiazka> getBookByName(@RequestParam String bookName) {
        return ksiazkaService.getByName(bookName);
    }

    @GetMapping("/search")
    public List<Ksiazka> getBookByISBN(@RequestParam String isbn){
        return ksiazkaService.getByISBN(isbn);
    }
}
