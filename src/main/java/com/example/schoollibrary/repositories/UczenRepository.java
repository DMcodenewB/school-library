package com.example.schoollibrary.repositories;

import com.example.schoollibrary.entities.Uczen;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UczenRepository {

    JdbcTemplate jdbcTemplate;

    public List<Uczen> getAll(){
        return jdbcTemplate.query("SELECT nr_ucznia, id_klasa, id_uzytkownik, imie_u, nazwisko_u FROM uczen",
                BeanPropertyRowMapper.newInstance(Uczen.class));
    }


}
