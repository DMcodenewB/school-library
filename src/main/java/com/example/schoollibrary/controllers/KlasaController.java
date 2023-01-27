package com.example.schoollibrary.controllers;

import com.example.schoollibrary.entities.Klasa;
import com.example.schoollibrary.services.KlasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/klasa")
public class KlasaController {

    @Autowired
    private KlasaService klasaService;

    @GetMapping("")
    public List<Klasa> getAllClasses(){
        return klasaService.getAll();
    }

    @GetMapping("/search")
    public List<Klasa> getClassByName(@RequestParam String nazwaKlasy){
        return klasaService.getClassByName(nazwaKlasy);
    }

}
