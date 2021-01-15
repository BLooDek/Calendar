package com.company;

public enum Statusy {
    proponowane,
    potwierdzone;

    public static Statusy getStatus(String inputString){
    //czy spotkanie jest potwierdzone tak/nie
        if(inputString.toLowerCase().equals("tak")) {
            return potwierdzone;
        } else if(inputString.toLowerCase().equals("nie")){
            return proponowane;
        }else {
            System.out.println("Nieznana odpowiedź, zakładam, że proponowane");
            return proponowane;
        }

    }

}
