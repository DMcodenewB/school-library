package com.example.schoollibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Ksiazka {
    private String isbn;
    private int id_dzial;
    private int id_autora;
    private String tytul;
    private String wydawnictwo;
    private int rok_wydania;
    private String okladka;
    private boolean czy_lektura;

}
