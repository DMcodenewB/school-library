package com.example.schoollibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wypozyczenie {
    private int id_wypozyczenie;
    private int id_uzytkownik;
    private String isbn;
    private String data_wypozyczenia;
    private int dlugosc_wypozyczenia;
    private String data_zwrotu;
}
