package com.ahd.prodcut.model;

public class Citys {
    private int id;
    private String name;
    private double census;
    private int city_code;

    public Citys(String name, double census, int city_code) {
        this.name = name;
        this.census = census;
        this.city_code = city_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCensus() {
        return census;
    }

    public void setCensus(double census) {
        this.census = census;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int city_code) {
        this.city_code = city_code;
    }
}
