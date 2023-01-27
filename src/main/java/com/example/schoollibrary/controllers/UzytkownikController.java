package com.example.schoollibrary.controllers;

import com.example.schoollibrary.entities.Uzytkownik;
import com.example.schoollibrary.services.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uzytkownik")
public class UzytkownikController {

    @Autowired
    private UzytkownikService uzytkownikService;

    @GetMapping("")
    public List<Uzytkownik> getAll(){
        return uzytkownikService.getAll();
    }

    @PostMapping("")
    public int addUser(@RequestBody Uzytkownik uzytkownik){
        return uzytkownikService.addUser(uzytkownik);
    }

    @PatchMapping("/change-pass")
    public int changePassword(@RequestBody Uzytkownik uzytkownik){
        return uzytkownikService.changePassword(uzytkownik);
    }
}
