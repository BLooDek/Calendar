package com.company;

public enum Priorytet {

    niski(1),
    normalny(2),
    wysoki(3);

    int poziom;

    Priorytet(int i) {
        this.poziom = i;
    }

    public int getPoziom() {
        return poziom;
    }

    public static Priorytet findByNumber(int val) {
        for (Priorytet value : values()) {
            if (value.poziom == val) {
                return value;
            }
        }
        return null;
    }

}
