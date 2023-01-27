package com.example.schoollibrary.repositories;

import com.example.schoollibrary.entities.Uczen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UczenRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Uczen> getAll(){
        return jdbcTemplate.query("SELECT nr_ucznia, id_klasa, u.id_uzytkownik, u.login, u.haslo, imie_u, nazwisko_u " +
                        "FROM uczen INNER JOIN uzytkownik u on uczen.id_uzytkownik = u.id_uzytkownik",
                BeanPropertyRowMapper.newInstance(Uczen.class));
    }

    public int save(Uczen uczen){
         return jdbcTemplate.update("INSERT INTO uczen(id_klasa, id_uzytkownik, imie_u, nazwisko_u) " +
                         "values(?,?,?,?)",
                 uczen.getId_klasa(),
                 uczen.getId_uzytkownik(),
                 uczen.getImie_u(),
                 uczen.getNazwisko_u());
    }


    public int deleteStudentAndUser(Uczen uczen) {
        jdbcTemplate.update("DELETE FROM uczen WHERE id_uzytkownik=?", uczen.getId_uzytkownik());
        jdbcTemplate.update("DELETE FROM uzytkownik where id_uzytkownik=?", uczen.getId_uzytkownik());
        return 1;
    }

    public Uczen getByLogin(String login) {
        return jdbcTemplate.queryForObject("SELECT nr_ucznia, id_klasa, u.id_uzytkownik, u.login, u.haslo, imie_u, nazwisko_u " +
                "FROM uczen INNER JOIN uzytkownik u on uczen.id_uzytkownik = u.id_uzytkownik WHERE u.login LIKE ?",
                BeanPropertyRowMapper.newInstance(Uczen.class), login);
    }
}
