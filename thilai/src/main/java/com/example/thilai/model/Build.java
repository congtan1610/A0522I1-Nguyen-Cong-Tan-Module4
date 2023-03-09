package com.example.thilai.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Build {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dayBuy;
    private Integer size;

    @ManyToOne
    @JoinColumn(name="idProduct")
    private Product product;

    public Build() {
    }

    public Build(Integer id, Date dayBuy, Integer size, Product product) {
        this.id = id;
        this.dayBuy = dayBuy;
        this.size = size;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(Date dayBuy) {
        this.dayBuy = dayBuy;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
