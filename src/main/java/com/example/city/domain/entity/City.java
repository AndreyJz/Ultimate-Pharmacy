package com.example.city.domain.entity;

public class City {
    private String id;
    private String name;
    private String  codereg;
    public City() {
    }
    public City(String id, String city, String codereg) {
        this.id = id;
        this.name = city;
        this.codereg = codereg;
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
    public String getCodereg() {
        return codereg;
    }
    public void setCodereg(String codereg) {
        this.codereg = codereg;
    }

    
}
