package com.company;


import java.time.LocalTime;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Spotkanie {
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private String opis;
    private Priorytet priorytet;
    private Statusy status;
    public static final LocalTime LOWEST_HOUR = LocalTime.of(4, 0); //public bo final

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

    public Statusy getStatus() {
        return status;
    }

    public Spotkanie(LocalTime czasPoczatku, LocalTime czasZakonczenia, String opis, Priorytet priorytet, Statusy status) {
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.opis = opis;
        this.priorytet = priorytet;
        this.status = status;
    }

    public String toString() {
        return String.format("spotkanie, Czas początku: '%s', Czas zakończenia: '%s' opis: '%s' priorytet: %s status: %s !!!",
                this.czasPoczatku.toString(), this.czasZakonczenia.toString(), this.opis, this.priorytet.name(), this.status.name());
    }






}



