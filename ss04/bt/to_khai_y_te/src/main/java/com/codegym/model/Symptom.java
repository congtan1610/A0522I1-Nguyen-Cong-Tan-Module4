package com.codegym.model;

public class Symptom {
    private String fever;
    private String cough;
    private String shortnessOfBreath;
    private String soreThroat;
    private String vomit;
    private String diarrhea;
    private String skinHemorrhage;
    private String skinRash;
    private String exposure1;
    private String exposure2;

    public Symptom() {
    }

    public Symptom(String fever, String cough, String shortnessOfBreath, String soreThroat, String vomit, String diarrhea, String skinHemorrhage, String skinRash, String exposure1, String exposure2) {
        this.fever = fever;
        this.cough = cough;
        this.shortnessOfBreath = shortnessOfBreath;
        this.soreThroat = soreThroat;
        this.vomit = vomit;
        this.diarrhea = diarrhea;
        this.skinHemorrhage = skinHemorrhage;
        this.skinRash = skinRash;
        this.exposure1 = exposure1;
        this.exposure2 = exposure2;
    }

    public String getFever() {
        return fever;
    }

    public void setFever(String fever) {
        this.fever = fever;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(String shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public String getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(String soreThroat) {
        this.soreThroat = soreThroat;
    }

    public String getVomit() {
        return vomit;
    }

    public void setVomit(String vomit) {
        this.vomit = vomit;
    }

    public String getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(String diarrhea) {
        this.diarrhea = diarrhea;
    }

    public String getSkinHemorrhage() {
        return skinHemorrhage;
    }

    public void setSkinHemorrhage(String skinHemorrhage) {
        this.skinHemorrhage = skinHemorrhage;
    }

    public String getSkinRash() {
        return skinRash;
    }

    public void setSkinRash(String skinRash) {
        this.skinRash = skinRash;
    }

    public String getExposure1() {
        return exposure1;
    }

    public void setExposure1(String exposure1) {
        this.exposure1 = exposure1;
    }

    public String getExposure2() {
        return exposure2;
    }

    public void setExposure2(String exposure2) {
        this.exposure2 = exposure2;
    }
}
