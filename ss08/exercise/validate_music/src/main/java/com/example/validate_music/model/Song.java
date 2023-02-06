package com.example.validate_music.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity
public class Song implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "cannot be left blank")
    @Size(max = 800,message = "Do not exceed 800 characters")
    private String name;
    @NotBlank(message = "cannot be left blank")
    @Size(max = 300,message = "Do not exceed 300 characters")
    private String artist;
    @NotBlank(message = "cannot be left blank")
    @Size(max = 1000,message = "Do not exceed 1000 characters")
    private String type;

    public Song() {
    }

    public Song(Integer id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song=(Song) target;
        if (!song.name.matches("^[a-zA-Z0-9\\+]*$")){
            errors.rejectValue("name","","name does not contain special characters");
        }
        if (!song.artist.matches("^[a-zA-Z0-9\\+]*$")){
            errors.rejectValue("artist","","artist does not contain special characters");
        }
        if (!song.type.matches("^[a-zA-Z0-9,\\+]*$")){
            errors.rejectValue("type","","type does not contain special characters");
        }
    }
}
