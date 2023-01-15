package com.example.schoollibrary.controllers;

import com.example.schoollibrary.entities.Autor;
import com.example.schoollibrary.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("")
    public List<Autor> getAllAuthors(){
        return autorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Autor getAuthorById(@PathVariable("id") int id_autora){
        return autorService.getAuthorById(id_autora);
    }

    @PostMapping("")
    public int addAutor(@RequestBody List<Autor> authors){
        return autorService.addAuthors(authors);
    }

    @PatchMapping("/{id}")
    public int updateAutorPut(@PathVariable("id") int id, @RequestBody Autor updatedAutor){
        return autorService.updateImieNazwisko(id, updatedAutor);
    }

    @DeleteMapping("/{id}")
    public int deleteAutor(@PathVariable("id") int id){
        return autorService.deleteAutor(id);
    }

}
