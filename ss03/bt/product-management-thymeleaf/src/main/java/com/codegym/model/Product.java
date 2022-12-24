package com.codegym.model;

import java.util.Objects;

public class Product {
    private String id;
    private String name;
    private Integer price;
    private String detail;
    private  String producer;

    public Product() {
    }

    public Product(String id, String name, Integer price, String detail, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.producer = producer;
    }

    public Product(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return 0;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
