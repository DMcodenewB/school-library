package com.example.schoollibrary.repositories;

import com.example.schoollibrary.entities.Klasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlasaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Klasa> getAll(){
        return jdbcTemplate.query("SELECT id_klasa, numer_klasy, profil FROM klasa",
                BeanPropertyRowMapper.newInstance(Klasa.class));
    }

    public Klasa getById(int id){
        return jdbcTemplate.queryForObject("SELECT id_klasa, numer_klasy, profil FROM klasa WHERE id_klasa=?",
                BeanPropertyRowMapper.newInstance(Klasa.class), id);
    }

    public Klasa getByName(String name){
        return jdbcTemplate.queryForObject("SELECT id_klasa, numer_klasy, profil FROM klasa WHERE numer_klasy LIKE ?",
                BeanPropertyRowMapper.newInstance(Klasa.class), name + "%");
    }

    //KlasaRepository doesn't need more funcionality
}
