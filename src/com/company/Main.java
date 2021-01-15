package com.company;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program do obsługi kalendarza miesięcznych spotkań");
        Kalendarz kalendarz = new Kalendarz();
        int opcje;
        do {
            wyswietlOpcje();

            opcje = pobierzInt("Wybierz opcje");
            switch (opcje) {
                case 0:
                    System.out.println("Do widzenia");
                    break;
                case 1:
                    kalendarz.dodajSpotkanie(pobierzInt("Podaj dzień miesiąca") - 1,
                            LocalTime.parse(pobierzString("Podaj czas początku ##:## lub ##:##:##")),
                            LocalTime.parse(pobierzString("Podaj czas końca ##:## lub ##:##:##")),
                            pobierzString("Podaj opis"),
                            Priorytet.findByNumber(pobierzInt("Podaj priorytet 1, 2 lub 3")));
                    break;
                case 2:
                    kalendarz.usunSpotkanie(pobierzInt("Podaj dzień")-1,
                            LocalTime.parse(pobierzString("Podaj czas początku spotkania które chcesz usunąć")));
                    break;
                case 3:
                    kalendarz.wyswietlSpotkanie(pobierzInt("Podaj dzień miesiąca")-1,
                            Priorytet.findByNumber(pobierzInt("Podaj priorytet 1, 2 lub 3")));
                    break;
                case 4:
                    kalendarz.wyswietlWszystkieSpotkania(pobierzInt("Podaj dzień miesiaca")-1);
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        } while (opcje != 0);
    }

    private static void wyswietlOpcje() {
        System.out.println("1. Aby dodać spotkanie");
        System.out.println("2. Aby usunąć spotaknie");
        System.out.println("3. Aby wyświetlić spotkania na określony dzień");
        System.out.println("0. Aby wyjść");
    }

    private static String pobierzString(String tekst) {
        Scanner odczyt = new Scanner(System.in);
        System.out.printf("%s : ", tekst);
        return odczyt.nextLine();
    }

    private static int pobierzInt(String tekst) {
        Scanner odczyt = new Scanner(System.in);
        System.out.printf("%s : ", tekst);
        while (!odczyt.hasNextInt()) {
            System.out.println("Wporwadź liczbe całkowitą");
            odczyt.next();
        }
        return odczyt.nextInt();
    }

}
