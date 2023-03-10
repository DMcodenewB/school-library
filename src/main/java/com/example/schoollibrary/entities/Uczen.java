package com.example.schoollibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uczen {
    private int nr_ucznia;
    private int id_klasa;
    private int id_uzytkownik;
    private String login; //only for java
    private String haslo; //only for java
    private String imie_u;
    private String nazwisko_u;
}
