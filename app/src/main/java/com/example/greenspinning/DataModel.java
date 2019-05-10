package com.example.greenspinning;

public class DataModel {

    String date;
    String wattProduced;
    String helperNames;

    public DataModel(String date, String wattProduced, String helperNames) {
        this.date = date;
        this.wattProduced = wattProduced;
        this.helperNames = helperNames;
    }

    public String getDate() {
        return date;
    }

    public String getWattProduced() {
        return wattProduced;
    }

    public String getHelperNames() {
        return helperNames;
    }

}