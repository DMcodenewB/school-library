package com.example.schoollibrary.controllers;

import com.example.schoollibrary.entities.Uczen;
import com.example.schoollibrary.services.UczenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uczen")
public class UczenController {

    @Autowired
    private UczenService uczenService;

    @GetMapping("")
    public List<Uczen> getAllStudents(){
        return uczenService.getAllStudents();
    }

    @GetMapping("/search")
    public Uczen getStudentByLogin(@RequestParam String login){
        return uczenService.getStudentByLogin(login);
    }

    @PostMapping("")
    public int addStudent(@RequestBody Uczen uczen){
        return uczenService.addStudent(uczen);
    }

    @DeleteMapping("/delete")
    public int deleteStudent(@RequestParam String login){
        return uczenService.deleteStudent(login);
    }
}
