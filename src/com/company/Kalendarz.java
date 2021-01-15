package com.company;

import java.time.LocalTime;
import java.util.ArrayList;

public class Kalendarz {
    private ArrayList<Spotkanie>[] miesiac;

    public Kalendarz() {
        this.miesiac = new ArrayList[31];
        for (int i = 0; i < 31; i++) {
            miesiac[i] = new ArrayList<>(10);
        }
    }

    public void dodajSpotkanie(int dzien, LocalTime startTime, LocalTime endTime, String opis, Priorytet priorytet) {
    if(startTime.isAfter(Spotkanie.LOWEST_HOUR)  )
    miesiac[dzien].add(new Spotkanie(startTime, endTime, opis, priorytet));
    }

    public void usunSpotkanie(int dzien, LocalTime startTime) {
        miesiac[dzien - 1].removeIf(index -> index.getCzasPoczatku().equals(startTime));
    }

    public void wyswietlSpotkanie(int dzien, Priorytet priorytet) {
        for (Spotkanie index : miesiac[dzien]) {
            if (index.getPriorytet().equals(priorytet)) {
                System.out.println(index.toString());
            }
        }
        System.out.println("-------------------------------------");
    }

    public void wyswietlWszystkieSpotkania(int dzien){
        for (Spotkanie index : miesiac[dzien]) {
            System.out.println(index.toString());
        }
        System.out.println("-------------------------------------");
    }

    private boolean validSpotkanie(int dzien, LocalTime now){
        for (Spotkanie index : miesiac[dzien]) {
            if ((!now.isBefore(index.getCzasPoczatku()) && now.isBefore(index.getCzasZakonczenia()))) {
                return false;
            }
        }
        return true;
    }
}
