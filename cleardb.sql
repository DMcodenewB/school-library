#################################################################################################
## ONLY RUN IF DATABASE RESET IS UNAVOIDABLE. IT WILL WIPE ALL THE DATABASE USERS AND BOOKINGS ##
#################################################################################################

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE autor, dzial, ksiazka, klasa, uzytkownik, nauczyciel, uczen, wypozyczenie;

SET FOREIGN_KEY_CHECKS = 1;