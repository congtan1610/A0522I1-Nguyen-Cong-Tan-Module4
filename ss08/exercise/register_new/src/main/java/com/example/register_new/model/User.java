package com.example.register_new.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Entity
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 5, max = 45, message = "incorrect")
    private String firstName;
    @Size(min = 5, max = 45, message = "incorrect")
    private String lastName;
    private String phoneNumber;
    @Min(18)
    private Integer age;
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
         return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (!user.phoneNumber.matches("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$")){
            errors.rejectValue("phoneNumber","","incorrect");
        }
        if (!user.email.matches("^[\\w.]+@[\\w&&[^_]]+([.][\\w&&[^_]]+){1,2}$")){
            errors.rejectValue("email","","incorrect");
        }
    }
}
