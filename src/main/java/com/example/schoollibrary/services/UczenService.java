package com.example.schoollibrary.services;

import com.example.schoollibrary.entities.Uczen;
import com.example.schoollibrary.entities.Uzytkownik;
import com.example.schoollibrary.repositories.UczenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UczenService {

    @Autowired
    private UczenRepository uczenRepository;
    @Autowired
    @Lazy
    private UzytkownikService uzytkownikService;


    public List<Uczen> getAllStudents(){
        return uczenRepository.getAll();
    }

    public int addStudent(Uczen newUczen){
        if (loginTaken(newUczen)){
            return -1;
        }

        //id_uzytkownik is set to anything outside the database scope. this field is auto assigned a value in database
        uzytkownikService.addUser(new Uzytkownik(-1, newUczen.getLogin(), newUczen.getHaslo()));

        newUczen.setId_uzytkownik(uzytkownikService.getByFullLogin(newUczen.getLogin()).getId_uzytkownik());
        return uczenRepository.save(newUczen);
    }

    private boolean loginTaken(Uczen newUczen) {
        boolean taken;

        HashSet<String> logins = uzytkownikService.getAll()
                .stream()
                .map(Uzytkownik::getLogin)
                .collect(Collectors.toCollection(HashSet::new));

        taken = logins.contains(newUczen.getLogin());
        return taken;
    }


    public int deleteStudent(String login) {
        Uczen u = getStudentByLogin(login);
        return uczenRepository.deleteStudentAndUser(u);
    }

    public Uczen getStudentByLogin(String login) {
        return uczenRepository.getByLogin(login);
    }
}
