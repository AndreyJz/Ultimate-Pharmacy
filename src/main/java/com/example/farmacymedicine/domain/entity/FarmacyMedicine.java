package com.example.farmacymedicine.domain.entity;

public class FarmacyMedicine {
    private int idFarmacy;
    private int idMedicineFartm;
    private float price;

    public FarmacyMedicine() {
    }

    public FarmacyMedicine(int idFarmacy, int idMedicineFartm, float price) {
        this.idFarmacy = idFarmacy;
        this.idMedicineFartm = idMedicineFartm;
        this.price = price;
    }

    public int getIdFarmacy() {
        return idFarmacy;
    }

    public void setIdFarmacy(int idFarmacy) {
        this.idFarmacy = idFarmacy;
    }

    public int getIdMedicineFartm() {
        return idMedicineFartm;
    }

    public void setIdMedicineFartm(int idMedicineFartm) {
        this.idMedicineFartm = idMedicineFartm;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
