package com.julia.consumindoapi2;

public class Modelo {
    Rates RatesObject;
    private String base;
    private String date;


    // Getter Methods

    public Rates getRates() {
        return RatesObject;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Reposta"
                + "\nBase: " + getBase()
                + "\nDate: " + getDate()
                + "\nRates" + getRates();
    }

    // Setter Methods

    public void setRates(Rates ratesObject) {
        this.RatesObject = ratesObject;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

