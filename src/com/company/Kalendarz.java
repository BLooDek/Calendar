package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;


public class Kalendarz {
    private ArrayList<Spotkanie>[] miesiac;

    public Kalendarz() {
        this.miesiac = new ArrayList[31];
        for (int i = 0; i < 31; i++) {
            miesiac[i] = new ArrayList<>(10);
        }
    }

    public void dodajSpotkanie(int dzien, LocalTime startTime, LocalTime endTime, String opis, Priorytet priorytet) {
        if (startTime.isAfter(Spotkanie.LOWEST_HOUR) && validSpotkanie(dzien, startTime) && validSpotkanie(dzien, endTime)) {
            miesiac[dzien].add(new Spotkanie(startTime, endTime, opis, priorytet));
            miesiac[dzien].sort(Comparator.comparing(Spotkanie::getCzasPoczatku));
        } else {
            System.out.println("Ten czas jest już zajęty!");
        }
    }


    public void usunSpotkanie(int dzien, LocalTime startTime) {
        miesiac[dzien].removeIf(index -> index.getCzasPoczatku().equals(startTime));
    }

    public void wyswietlSpotkanie(int dzien, Priorytet priorytet) {
        int nrWydarzenia = 1;
        for (Spotkanie index : miesiac[dzien]) {
            if (index.getPriorytet().equals(priorytet)) {
                System.out.printf("%d. %s \n", nrWydarzenia, index.toString());
                nrWydarzenia++;
            }
        }
        System.out.println("-------------------------------------");
    }

    public void wyswietlWszystkieSpotkania(int dzien) {
        int nrWydarzenia = 1;
        for (Object index : miesiac[dzien]) {
            System.out.printf("%d. %s \n", nrWydarzenia, index.toString());
            nrWydarzenia++;
        }
        System.out.println("-------------------------------------");
    }

    private boolean validSpotkanie(int dzien, LocalTime now) {
        for (Spotkanie index : miesiac[dzien]) {
            if ((!now.isBefore(index.getCzasPoczatku()) && now.isBefore(index.getCzasZakonczenia()))) {
                return false;
            }
        }
        return true;
    }
}
