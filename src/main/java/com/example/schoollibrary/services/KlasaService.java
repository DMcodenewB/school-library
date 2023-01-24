package com.example.schoollibrary.services;

import com.example.schoollibrary.entities.Klasa;
import com.example.schoollibrary.repositories.KlasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlasaService {

    @Autowired
    KlasaRepository klasaRepository;

    public List<Klasa> getAll(){
        return klasaRepository.getAll();
    }

    public Klasa getClassByName(String nazwaKlasy){
        return klasaRepository.getByName(nazwaKlasy);
    }


}
