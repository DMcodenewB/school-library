package com.example.schoollibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nauczyciel {
    private int id_nauczyciel;
    private int id_uzytkownik;
    private String imie_n;
    private String nazwisko_n;
    private String przedmiot_glowny;
    private String przedmiot_poboczny;
}
