package com.example.schoollibrary.repositories;

import com.example.schoollibrary.entities.Dzial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DzialRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Dzial> getAll(){
        return jdbcTemplate.query("SELECT id_dzial, nazwa FROM dzial",
                BeanPropertyRowMapper.newInstance(Dzial.class));
    }

    public Dzial getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id_dzial, nazwa FROM dzial WHERE id_dzial=?",
                BeanPropertyRowMapper.newInstance(Dzial.class), id);
    }

    public List<Dzial> getByNameStart(String name){
        return jdbcTemplate.query("SELECT id_dzial, nazwa FROM dzial WHERE nazwa LIKE ?",
                BeanPropertyRowMapper.newInstance(Dzial.class), name +"%");
    }

    //I presume only reading is needed for this entity repository
}
