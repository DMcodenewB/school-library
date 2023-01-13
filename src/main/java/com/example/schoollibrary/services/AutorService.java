package com.example.schoollibrary.services;

import com.example.schoollibrary.entities.Autor;
import com.example.schoollibrary.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAllAuthors(){
        return autorRepository.getAll();
    }

    public Autor getAutorById(int id){
        return autorRepository.getById(id);
    }

    //dokonczyc usuwanie i update

}
