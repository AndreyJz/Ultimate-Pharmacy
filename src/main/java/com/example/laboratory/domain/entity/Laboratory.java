package com.example.laboratory.domain.entity;

public class Laboratory {
    private int id;
    private String name;
    private String codeCityReg;

    public Laboratory() {
    }

    public Laboratory(int id, String name, String codeCityReg) {
        this.id = id;
        this.name = name;
        this.codeCityReg = codeCityReg;
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

    public String getCodeCityReg() {
        return codeCityReg;
    }

    public void setCodeCityReg(String codeCityReg) {
        this.codeCityReg = codeCityReg;
    }
}
