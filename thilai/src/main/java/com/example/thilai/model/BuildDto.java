package com.example.thilai.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class BuildDto implements Validator {
    private Integer id;
    private String dayBuy;
    @NotNull(message = "Không được để trống")
    @Min(value = 0,message = "Số lượng phải là số nguyên dương")
    private Integer size;
    private Product product;

    public BuildDto() {
    }

    public BuildDto(Integer id, String dayBuy, Integer size, Product product) {
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

    public String getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(String dayBuy) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    BuildDto buildDto=(BuildDto) target;
        java.util.Date dayBuy=null;
        try {
            dayBuy = new SimpleDateFormat("yyyy-MM-dd").parse(buildDto.dayBuy);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!(dayBuy == null)) {
            LocalDate temp = dayBuy.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(java.time.LocalDate.now(), temp).getDays() <=0) {
                errors.rejectValue("dayBuy", "", "ngày nhập vào nhỏ hơn ngày hiện tại");
            }
        }
    }
}
