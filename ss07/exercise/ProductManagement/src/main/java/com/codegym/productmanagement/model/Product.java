package com.codegym.productmanagement.model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Entity
public class Product implements Validator {
    @Id
    @Column(name="ma_san_pham")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "ten_san_pham")
    @NotBlank(message = "cannot be left blank")
    private String name;
    @Column(name = "gia")
    @NotNull(message = "cannot be left blank")
    private Integer price;
    @Column(name="chi_tiet")
    @NotBlank(message = "cannot be left blank")
    private String detail;
    @Column(name = "nha_san_xuat")
    @NotBlank(message = "cannot be left blank")
    private  String producer;

    public Product() {
    }

    public Product(Integer id, String name, Integer price, String detail, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.producer = producer;
    }

    public Product(Integer id) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product=(Product) target;
        if (!product.name.matches("^[a-zA-Z0-9\\+]*$")){
            errors.rejectValue("name","","name does not contain special characters");
        }
        if (!product.detail.matches("^[a-zA-Z0-9\\+]*$")){
            errors.rejectValue("artist","","artist does not contain special characters");
        }
        if (!product.producer.matches("^[a-zA-Z0-9\\+]*$")){
            errors.rejectValue("artist","","artist does not contain special characters");
        }
    }
}
