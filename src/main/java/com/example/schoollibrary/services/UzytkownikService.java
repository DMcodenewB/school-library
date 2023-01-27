package com.example.schoollibrary.services;

import com.example.schoollibrary.entities.Uzytkownik;
import com.example.schoollibrary.repositories.UzytkownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UzytkownikService {

    @Autowired
    private UzytkownikRepository uzytkownikRepository;

    public List<Uzytkownik> getAll(){
        return uzytkownikRepository.getAll();
    }

    public Uzytkownik getByFullLogin(String fullLogin){
        return uzytkownikRepository.getByLogin(fullLogin);
    }

    public int addUser(Uzytkownik uzytkownik) {
        return uzytkownikRepository.save(uzytkownik);
    }

    public int changePassword(Uzytkownik uzytkownik) {
        return uzytkownikRepository.updateHaslo(uzytkownik);
    }
}
