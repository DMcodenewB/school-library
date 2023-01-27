package com.example.schoollibrary.services;

import com.example.schoollibrary.entities.Ksiazka;
import com.example.schoollibrary.repositories.KsiazkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KsiazkaService {

    @Autowired
    private KsiazkaRepository ksiazkaRepository;

    public List<Ksiazka> getAll(){
        return ksiazkaRepository.getAll();
    }

    public List<Ksiazka> getByName(String bookName) {
        return ksiazkaRepository.getByTytul(bookName);
    }
}
