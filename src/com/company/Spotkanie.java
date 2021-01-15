package com.company;


import java.time.LocalTime;


public class Spotkanie {
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private String opis;
    private Priorytet priorytet;
    public static final LocalTime LOWEST_HOUR = LocalTime.of(0, 0); //public bo final

    public LocalTime getCzasPoczatku() {
        return czasPoczatku;
    }

    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public String getOpis() {
        return opis;
    }

    public Priorytet getPriorytet() {
        return priorytet;
    }

    public Spotkanie(LocalTime czasPoczatku, LocalTime czasZakonczenia, String opis, Priorytet priorytet) {
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.opis = opis;
        this.priorytet = priorytet;
    }

    public String toString() {
        return String.format("spotkanie, Czas początku: '%s', Czas zakończenia: '%s' opis: '%s' priorytet: %s!!!", this.czasPoczatku.toString(), this.czasZakonczenia.toString(), this.opis, this.priorytet.name());
    }


}



