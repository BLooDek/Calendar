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
            System.out.println(pobierzCzas("początku "));
            opcje = pobierzInt("Wybierz opcje");
            switch (opcje) {
                case 0:
                    System.out.println("Do widzenia");
                    break;
                case 1:
                    kalendarz.dodajSpotkanie();
                    break;
                case 2:
                    kalendarz.usunSpotkanie();
                    break;
                case 3:
                    kalendarz.wyswietlSpotkanie();
                    break;
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

    //Parsowanie czasu ze stringa
    private static LocalTime pobierzCzas(String optional) {
        Scanner odczyt = new Scanner(System.in);
        while (true) {
            System.out.printf("Podaj czas %sw formacie ##:##: ", optional);
            String[] array = odczyt.next().split(":");
            int a = -1;
            int b = -1;
            try {
                if (array.length == 2) {
                    a = Integer.parseInt(array[0]);
                    b = Integer.parseInt(array[1]);
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (a < 24 && a > -1 && b > -1 && b < 60) {
                return LocalTime.of(a, b);
            }
        }

    }
}
