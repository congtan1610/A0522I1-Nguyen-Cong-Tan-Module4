package com.example.thi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class SaleDto implements Validator {
    private Integer id;
    @NotBlank(message = "không được trống")
    private String title;
    @NotBlank(message = "không được trống")
    private String dateStart;
    @NotBlank(message = "không được trống")
    private String dateEnd;
    @NotNull(message = "không được trống")
    @Min(value = 10000,message = "không được nhỏ hơn 10000")
    private Integer rangeSale;
    @NotBlank(message = "không được trống")
    private String detail;

    public SaleDto() {
    }

    public SaleDto(Integer id, String title, String dateStart, String dateEnd, Integer rangeSale, String detail) {
        this.id = id;
        this.title = title;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.rangeSale = rangeSale;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getRangeSale() {
        return rangeSale;
    }

    public void setRangeSale(Integer rangeSale) {
        this.rangeSale = rangeSale;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SaleDto sale=(SaleDto) target;
        java.util.Date start=null;
        Date end=null;
        try {
            start = new SimpleDateFormat("yyyy-MM-dd").parse(sale.dateStart);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            end =  new SimpleDateFormat("yyyy-MM-dd").parse(sale.dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        ngay hien nhap vao lon hon ngay hien tai
        if (!(start == null)) {
            LocalDate temp = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(java.time.LocalDate.now(), temp).getDays() <=0) {
                errors.rejectValue("dateStart", "", "ngày nhập vào nhỏ hơn ngày hiện tại");
            }
        }
        if (!(end == null)) {
            LocalDate temp1 = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(java.time.LocalDate.now(), temp1).getDays() <=0) {
                errors.rejectValue("dateEnd", "", "ngày nhập vào nhỏ hơn ngày hiện tại");
            }
        }
//        ngay ket thuc lon hon ngay bat dau
        if (!(end == null)&&!(start == null)) {
            LocalDate temp1 = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate temp2 = end.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(temp1,temp2 ).getDays() <=0) {
                errors.rejectValue("dateEnd", "", "ngày kết thúc phải lớn hơn ngày bắt đầu");
            }
        }
    }
}
