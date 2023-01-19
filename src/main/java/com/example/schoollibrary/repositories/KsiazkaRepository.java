package com.example.schoollibrary.repositories;

import com.example.schoollibrary.entities.Ksiazka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KsiazkaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Ksiazka> getAll(){
        return jdbcTemplate.query("SELECT isbn," +
                " id_dzial," +
                " id_autora," +
                " tytul," +
                " wydawnictwo," +
                " rok_wydania," +
                " okladka," +
                " czy_lektura" +
                "FROM ksiazka",
                BeanPropertyRowMapper.newInstance(Ksiazka.class));
    }

    public Ksiazka getByISBN(String isbn){
        return jdbcTemplate.queryForObject("SELECT isbn," +
                " id_dzial," +
                " id_autora," +
                " tytul," +
                " wydawnictwo," +
                " rok_wydania," +
                " okladka," +
                " czy_lektura" +
                "FROM ksiazka WHERE isbn LIKE ?",
                BeanPropertyRowMapper.newInstance(Ksiazka.class), isbn);
    }

    public List<Ksiazka> getByTytul(String tytul){
        return jdbcTemplate.query("SELECT isbn," +
                        " id_dzial," +
                        " id_autora," +
                        " tytul," +
                        " wydawnictwo," +
                        " rok_wydania," +
                        " okladka," +
                        " czy_lektura" +
                        "FROM ksiazka WHERE tytul LIKE ?%",
                BeanPropertyRowMapper.newInstance(Ksiazka.class), tytul);
    }
    //KsiazkaRepository does not need more functionality

}
