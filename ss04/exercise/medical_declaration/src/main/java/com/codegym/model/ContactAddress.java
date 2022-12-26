package com.codegym.model;

public class ContactAddress {
    private String city;
    private String district;
    private String warm;
    private String addressOfResidence;
    private String phone;
    private String email;

    public ContactAddress() {
    }

    public ContactAddress(String city, String district, String warm, String addressOfResidence, String phone, String email) {
        this.city = city;
        this.district = district;
        this.warm = warm;
        this.addressOfResidence = addressOfResidence;
        this.phone = phone;
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWarm() {
        return warm;
    }

    public void setWarm(String warm) {
        this.warm = warm;
    }

    public String getAddressOfResidence() {
        return addressOfResidence;
    }

    public void setAddressOfResidence(String addressOfResidence) {
        this.addressOfResidence = addressOfResidence;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
