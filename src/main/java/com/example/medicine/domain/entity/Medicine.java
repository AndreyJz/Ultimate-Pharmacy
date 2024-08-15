package com.example.medicine.domain.entity;

public class Medicine {
    private int id;
    private String proceedings;
    private String name;
    private String healthRegister;
    private String description;
    private String descriptionShort;
    private int codeModeAdmin;
    private int codePa;
    private int codeUm;
    private int codeLab;

    public Medicine() {
    }

    public Medicine(int id, String proceedings, String name, String healthRegister, String description,
                    String descriptionShort, int codeModeAdmin, int codePa, int codeUm, int codeLab) {
        this.id = id;
        this.proceedings = proceedings;
        this.name = name;
        this.healthRegister = healthRegister;
        this.description = description;
        this.descriptionShort = descriptionShort;
        this.codeModeAdmin = codeModeAdmin;
        this.codePa = codePa;
        this.codeUm = codeUm;
        this.codeLab = codeLab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProceedings() {
        return proceedings;
    }

    public void setProceedings(String proceedings) {
        this.proceedings = proceedings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealthRegister() {
        return healthRegister;
    }

    public void setHealthRegister(String healthRegister) {
        this.healthRegister = healthRegister;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public int getCodeModeAdmin() {
        return codeModeAdmin;
    }

    public void setCodeModeAdmin(int codeModeAdmin) {
        this.codeModeAdmin = codeModeAdmin;
    }

    public int getCodePa() {
        return codePa;
    }

    public void setCodePa(int codePa) {
        this.codePa = codePa;
    }

    public int getCodeUm() {
        return codeUm;
    }

    public void setCodeUm(int codeUm) {
        this.codeUm = codeUm;
    }

    public int getCodeLab() {
        return codeLab;
    }

    public void setCodeLab(int codeLab) {
        this.codeLab = codeLab;
    }
}
