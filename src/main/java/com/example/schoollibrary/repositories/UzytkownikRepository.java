package com.example.schoollibrary.repositories;

import com.example.schoollibrary.entities.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UzytkownikRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Uzytkownik> getAll(){
        return jdbcTemplate.query("SELECT id_uzytkownik, login, haslo FROM uzytkownik",
                BeanPropertyRowMapper.newInstance(Uzytkownik.class));
    }

    public Uzytkownik getByLogin(String login){
        return jdbcTemplate.queryForObject("SELECT id_uzytkownik, login, haslo FROM uzytkownik WHERE login LIKE ?",
                BeanPropertyRowMapper.newInstance(Uzytkownik.class), login);
    }

    public int save(Uzytkownik newUzytkownik){
        jdbcTemplate.update("INSERT INTO uzytkownik(login, haslo) values (?, ?)",
                newUzytkownik.getLogin(),
                newUzytkownik.getHaslo());

        return 1;
    }

    public int updateHaslo(Uzytkownik updatedUzytkownikHaslo){
        return jdbcTemplate.update("UPDATE uzytkownik SET haslo=? WHERE login LIKE ?",
                updatedUzytkownikHaslo.getHaslo(), updatedUzytkownikHaslo.getLogin());
    }
}
