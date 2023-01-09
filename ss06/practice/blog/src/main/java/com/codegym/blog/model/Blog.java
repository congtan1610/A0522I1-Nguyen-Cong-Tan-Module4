package com.codegym.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String detail;

    public Blog() {
    }

    public Blog(Integer id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
