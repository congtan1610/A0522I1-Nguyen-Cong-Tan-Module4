package com.example.furama.model.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


public class CustomerDto implements Validator {
    private Long id;
    @NotBlank(message = "cannot be left blank")
    @Size(max = 45, message = "Do not exceed 45 characters")
    @Pattern(regexp = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$", message = "name failed")
    private String name;
    @NotBlank(message = "cannot be left blank")
    private String dateOfBirth;
    private Byte gender;
    @NotBlank(message = "cannot be left blank")
    @Pattern(regexp = "^([\\d]{9}|[\\d]{12})$", message = "id card failed")
    private String idCard;
    @NotBlank(message = "cannot be left blank")
    @Pattern(regexp = "^(090|091|(84)+90|(84)+91)[\\d]{7}$", message = "phone number failed")
    private String phoneNumber;
    @NotBlank(message = "cannot be left blank")
    @Pattern(regexp = "[\\w.]+@[\\w]+([.][\\w]+){1,2}$", message = "email failed")
    private String email;
    @NotBlank(message = "cannot be left blank")
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String dateOfBirth, Byte gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customer = (CustomerDto) target;
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(customer.dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!(birthDate == null)) {
            LocalDate temp = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(java.time.LocalDate.now(), temp).getYears() > -18) {
                errors.rejectValue("dateOfBirth", "", "younger than 18 years old");
            }
        }
    }
}
