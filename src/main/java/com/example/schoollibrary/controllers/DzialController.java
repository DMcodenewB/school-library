package com.example.schoollibrary.controllers;

import com.example.schoollibrary.entities.Dzial;
import com.example.schoollibrary.services.DzialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dzial")
public class DzialController {

    @Autowired
    private DzialService dzialService;

    @GetMapping("")
    public List<Dzial> getAllSections(){
        return dzialService.getAllSections();
    }

    @GetMapping("/{id}")
    public Dzial getBySectionId(@PathVariable("id") int sectionId){
        return dzialService.getSectionById(sectionId);
    }

    @GetMapping("/search")
    public List<Dzial> searchByName(@RequestParam String name) {
        return dzialService.getByNameStart(name);
    }
}
