package com.example.schoollibrary.services;

import com.example.schoollibrary.entities.Autor;
import com.example.schoollibrary.entities.Dzial;
import com.example.schoollibrary.repositories.AutorRepository;
import com.example.schoollibrary.repositories.DzialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DzialService {

    @Autowired
    private DzialRepository dzialRepository;

    public List<Dzial> getAllSections(){
        return dzialRepository.getAll();
    }

    public Dzial getSectionById(int id){
        return dzialRepository.getById(id);
    }

    public List<Dzial> getByNameStart(String nameStr){
        return dzialRepository.getByNameStart(nameStr);
    }

}
