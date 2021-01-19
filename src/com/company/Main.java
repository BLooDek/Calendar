package com.company;

import java.time.LocalTime;
import java.util.Scanner;
//import java.util.function.BiFunction;


public class Main {

    public static void main(String[] args) {
        System.out.println("Program do obsługi kalendarza miesięcznych spotkań");
        Kalendarz kalendarz = new Kalendarz();
        /*dotestów
        kalendarz.dodajSpotkanie(0, LocalTime.parse("12:30"), LocalTime.parse("12:35"), "Jeden", Priorytet.findByNumber(1), Statusy.getStatus("Tak"));
        kalendarz.dodajSpotkanie(0, LocalTime.parse("13:30"), LocalTime.parse("13:35"), "Jeden", Priorytet.findByNumber(1), Statusy.getStatus("Nie"));
        kalendarz.dodajSpotkanie(0, LocalTime.parse("14:30"), LocalTime.parse("15:35"), "Jeden", Priorytet.findByNumber(2), Statusy.getStatus("Tak"));
        kalendarz.dodajSpotkanie(0, LocalTime.parse("16:30"), LocalTime.parse("17:35"), "Jeden", Priorytet.findByNumber(2), Statusy.getStatus("Nie"));
        kalendarz.dodajSpotkanie(0, LocalTime.parse("05:30"), LocalTime.parse("06:35"), "Jeden", Priorytet.findByNumber(2), Statusy.getStatus("Nie"));
        kalendarz.dodajSpotkanie(0, LocalTime.parse("07:30"), LocalTime.parse("08:35"), "Jeden", Priorytet.findByNumber(2), Statusy.getStatus("Nie"));
*/

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
                            Priorytet.findByNumber(pobierzInt("Podaj priorytet 1, 2 lub 3")),
                            Statusy.getStatus(pobierzString("Spotkanie potwierdzone tak/nie")));
                    break;
                case 2:
                    kalendarz.usunSpotkanie(pobierzInt("Podaj dzień") - 1,
                            LocalTime.parse(pobierzString("Podaj czas początku spotkania które chcesz usunąć")));
                    break;
                case 3:
                    kalendarz.wyswietlLambda(pobierzInt("Podaj dzień miesiąca") - 1, i -> true);
                    break;
                case 4:
                    Priorytet prioryty = Priorytet.findByNumber(pobierzInt("Podaj nr prioytetu"));
                    kalendarz.wyswietlLambda(pobierzInt("Podaj dzień miesiąca") - 1, i -> i.getPriorytet().equals(prioryty));
                    break;
                case 5:
                    Priorytet prioryty2 = Priorytet.findByNumber(pobierzInt("Podaj nr prioytetu"));
                    LocalTime testTime = LocalTime.parse(pobierzString("Podaj czas po którym chcesz wyświetlić"));

                    kalendarz.wyswietlLambda(pobierzInt("Podaj dzień miesiąca") - 1,
                            i -> (i.getPriorytet().equals(prioryty2) && (i.getCzasPoczatku().isAfter(testTime) || i.getCzasPoczatku().equals(testTime))));
                    break;
                case 6:
                    Priorytet prioryty3 = Priorytet.findByNumber(pobierzInt("Podaj nr prioytetu"));
                    Statusy statusy = Statusy.getStatus("Spotkanie potwierdzone tak/nie");
                    kalendarz.wyswietlLambda(
                            pobierzInt("Podaj dzień miesiąca") - 1, i -> i.getPriorytet().equals(prioryty3) && i.getStatus().equals(statusy));
                default:
                    System.out.println("Nie ma takiej opcji");
                    break;
            }
        } while (opcje != 0);

    }

    private static void wyswietlOpcje() {
        System.out.println("1. Aby dodać spotkanie");
        System.out.println("2. Aby usunąć spotaknie");
        System.out.println("3. Aby wyświetlić wszystkie spotkania");
        System.out.println("4. wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie");
        System.out.println("5. wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie i\n" +
                "zaczynających się o podanym czasie lub później");
        System.out.println("6. wyświetlenie wszystkich spotkań w wybranym dniu o wybranym priorytecie i\n" +
                "statusie");
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
