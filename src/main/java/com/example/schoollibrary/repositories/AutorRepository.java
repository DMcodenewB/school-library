package com.example.schoollibrary.repositories;

import com.example.schoollibrary.entities.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Autor> getAll(){
        return jdbcTemplate.query("SELECT id_autora, imieNazwiskoAutora FROM autor",
                BeanPropertyRowMapper.newInstance(Autor.class));
    }

    public Autor getById(int id){
        return jdbcTemplate.queryForObject("SELECT id_autora, imieNazwiskoAutora FROM autor WHERE id_autora=?",
                BeanPropertyRowMapper.newInstance(Autor.class), id);
    }

    public List<Autor> getByName(String name) {
        return jdbcTemplate.query("SELECT id_autora, imieNazwiskoAutora from autor where imieNazwiskoAutora=?",
                BeanPropertyRowMapper.newInstance(Autor.class), name+"%");
    }

    public int save(List<Autor> autorzy){
        autorzy.forEach(autor -> jdbcTemplate
                .update("INSERT INTO autor(imieNazwiskoAutora) values (?)",
                        autor.getImieNazwiskoAutora()
                ));
        return 1;
    }

    public int update(Autor autor){
        return jdbcTemplate.update("UPDATE autor SET imieNazwiskoAutora=? WHERE id_autora=?",
                autor.getImieNazwiskoAutora(), autor.getId_autora());
    }

    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM autor WHERE id_autora=?", id);
    }
}
