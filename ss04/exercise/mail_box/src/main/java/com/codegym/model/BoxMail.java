package com.codegym.model;

public class BoxMail {
    private String language;
    private Integer pageSize;
    private String spams;
    private String signature;

    public BoxMail(String language, Integer pageSize, String spams, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spams = spams;
        this.signature = signature;
    }

    public BoxMail() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpams() {
        return spams;
    }

    public void setSpams(String spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
