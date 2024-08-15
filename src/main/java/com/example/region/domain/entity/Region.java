package com.example.region.domain.entity;

public class Region {
    private String id;
    private String name;
    private String codecountry;
    public Region() {
    }
    public Region(String id, String city, String codecountry) {
        this.id = id;
        this.name = city;
        this.codecountry = codecountry;
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
    public String getCodecountry() {
        return codecountry;
    }
    public void setCodecountry(String codereg) {
        this.codecountry = codereg;
    }
}
