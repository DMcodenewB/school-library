create database if not exists schoollibrary CHARACTER SET 'utf8mb4' collate 'utf8mb4_polish_ci';

use schoollibrary;

create table autor (
    id_autora int AUTO_INCREMENT NOT NULL,
    imieNazwiskoAutora VARCHAR(255) NOT NULL,
    constraint pk_id_autora primary key(id_autora)
);

create table dzial(
    id_dzial int AUTO_INCREMENT not null,
    nazwa varchar(50) not null,
    constraint pk_id_dzial primary key(id_dzial)
);

create table ksiazka(
    isbn varchar(30) not null,
    id_dzial int not null,
    id_autora int not null,
    tytul varchar(50) not null,
    wydawnictwo varchar(50) not null,
    rok_wydania int not null,
    okladka varchar(50) not null,
    czy_lektura boolean not null,
    constraint pk_isbn primary key(isbn),
    foreign key (id_dzial) references dzial(id_dzial),
    foreign key (id_autora) references autor(id_autora)
);

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

create table nauczyciel(
    id_nauczyciel int AUTO_INCREMENT not null,
    id_uzytkownik int not null,
    imie_n varchar(50) not null,
    nazwisko_n varchar(50) not null,
    constraint pk_id_nauczyciel primary key(id_nauczyciel),
    foreign key (id_uzytkownik) references uzytkownik(id_uzytkownik)
);

create table uczen(
    nr_ucznia int AUTO_INCREMENT not null,
    id_klasa int not null,
    id_uzytkownik int not null,
    imie_u varchar(50) not null,
    nazwisko_u varchar(50) not null,
    constraint pk_nr_ucznia primary key(nr_ucznia),
    foreign key (id_klasa) references klasa(id_klasa),
    foreign key (id_uzytkownik) references uzytkownik(id_uzytkownik)
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

insert into autor(imieNazwiskoAutora) values ('Henryk Sienkiewicz');
insert into autor(imieNazwiskoAutora) values ('Albert Camus');
insert into autor(imieNazwiskoAutora) values ('Andrzej Sapkowski');
insert into autor(imieNazwiskoAutora) values ('Sofokles');
insert into autor(imieNazwiskoAutora) values ('Jan Kochanowski');
insert into autor(imieNazwiskoAutora) values ('Frank Herbert');
insert into autor(imieNazwiskoAutora) values ('Władysław Reymont');
insert into autor(imieNazwiskoAutora) values ('Herbert George Wells');

insert into dzial(nazwa) values ('Fantastyka');
insert into dzial(nazwa) values ('Science Fiction');
insert into dzial(nazwa) values ('Poezja');
insert into dzial(nazwa) values ('Dramat');
insert into dzial(nazwa) values ('Historyczne');
insert into dzial(nazwa) values ('Przyrodnicze');

insert into ksiazka values ('9788364476914', 2, 6, 'Diuna', 'Literka', 2021, 'miękka', 0);
insert into ksiazka values ('9781234567897', 4, 4, 'Antygona', 'ATENA', 2005, 'miękka', 1);
insert into ksiazka values ('9781873671009', 5, 2, 'Dżuma', 'Literka', 1999, 'twarda', 1);
insert into ksiazka values ('9782123456803', 5, 1, 'Quo Vadis', 'Boluki', 2013, 'twarda', 1);
insert into ksiazka values ('9788371807664', 3, 5, 'Treny', 'ATENA', 2009, 'miękka', 1);
insert into ksiazka values ('9788364640148', 4, 2, 'Kaligula', 'Literka', 2018, 'miękka', 0);
insert into ksiazka values ('9783161484100', 5, 1, 'Krzyżacy', 'Boluki', 2016, 'twarda', 1);
insert into ksiazka values ('9788393157682', 1, 3, 'Krew Elfów', 'Boluki', 2001, 'twarda', 0);
insert into ksiazka values ('9788391810668', 2, 8, 'Wojna Światów', 'Literka', 1999, 'miękka', 0);
insert into ksiazka values ('9788395730672', 1, 3, 'Wieża Jaskółki', 'Boluki', 2001, 'twarda', 0);
insert into ksiazka values ('9781782808084', 5, 7, 'Chłopi', 'ATENA', 2010, 'miękka', 1);

insert into klasa(numer_klasy, profil) values ('1A', 'mat-fiz');
insert into klasa(numer_klasy, profil) values ('1B', 'biol-chem');
insert into klasa(numer_klasy, profil) values ('1C', 'pol-hist');
insert into klasa(numer_klasy, profil) values ('2A', 'mat-fiz');
insert into klasa(numer_klasy, profil) values ('2B', 'biol-chem');
insert into klasa(numer_klasy, profil) values ('3A', 'mat-fiz');
insert into klasa(numer_klasy, profil) values ('3B', 'biol-chem');