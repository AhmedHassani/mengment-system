package com.ahd.prodcut.model;
import org.springframework.lang.NonNull;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Pordcut{
    private String id;

    private String name;

    private Set set;

    private String price;

    private Date date;

    private Map<String,Object> other;

    public Pordcut() {
        date=new Date();
        other=new HashMap<>();
    }

    public Pordcut(String name,  Set set,String price) {
        this();
        this.name = name;
        this.set = set;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSet() {
        return set.getName();
    }

    public Set getSetObject() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Object> getOther() {
        return other;
    }

    public void setOther(Map<String, Object> other) {
        this.other = other;
    }
}
