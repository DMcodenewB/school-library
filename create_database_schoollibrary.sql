use schoollibrary;

create table klasa(
    id_klasa int AUTO_INCREMENT,
    numer_klasy varchar (50) not null,
    profil VARCHAR (50) not null,
    constraint pk_klasa primary key(id_klasa)
);

create table uzytkownik(
   id_uzytkownik int AUTO_INCREMENT not null,
   login varchar(50) not null,
   haslo varchar(50) not null,
   constraint pk_id_uzytkownik primary key(id_uzytkownik)
);

create table dzial(
    id_dzial int AUTO_INCREMENT not null,
    nazwa varchar(50) not null,
    constraint pk_id_dzial primary key(id_dzial)
);

create table nauczyciel(
    id_nauczyciel int AUTO_INCREMENT not null,
    id_uzytkownik int not null,
    imie_n varchar(50) not null,
    nazwisko_n varchar(50) not null,
    przedmiot_glowny varchar(50) not null,
    przedmiot_poboczny varchar(50),
    constraint pk_id_nauczyciel primary key(id_nauczyciel),
    foreign key (id_uzytkownik) references uzytkownik(id_uzytkownik)
);

create table uczen(
    nr_ucznia int AUTO_INCREMENT not null,
    id_klasa int not null,
    id_uzytkownik int not null,
    imie_u varchar(50) not null,
    nazwisko_u varchar(50) not null,
    zachowanie varchar(50) not null,
    constraint pk_nr_ucznia primary key(nr_ucznia),
    foreign key (id_klasa) references klasa(id_klasa),
    foreign key (id_uzytkownik) references uzytkownik(id_uzytkownik)
);

create table autor (
    id_autora int NOT NULL,
    imieNazwiskoAutora VARCHAR(255) NOT NULL,
    constraint pk_id_autora primary key(id_autora)
);

create table ksiazka(
    isbn varchar(30) not null,
    id_dzial int not null,
    tytul varchar(50) not null,
    id_autora int not null,
    wydawnictwo varchar(50) not null,
    rok_wydania int not null,
    okladka varchar(50) not null,
    lektura boolean not null,
    constraint pk_isbn primary key(isbn),
    foreign key (id_dzial) references dzial(id_dzial),
    foreign key (id_autora) references autor(id_autora)
);

create table wypozyczenie(
    id_wypozyczenie int AUTO_INCREMENT not null,
    id_uzytkownik int not null,
    isbn varchar(30) not null,
    data_wypozyczenia datetime not null,
    dlugosc_wypozyczenia int not null,
    data_zwrotu datetime,
    constraint pk_id_wypozyczenie primary key(id_wypozyczenie),
    foreign key (id_uzytkownik) references uzytkownik(id_uzytkownik),
    foreign key (isbn) references ksiazka(isbn)
);