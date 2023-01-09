package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
public class Entity {
    @Id
    private Integer id;
    private String name;
    private String artist;
    private String type;
    private String filePath;

    public Entity(Integer id, String name, String artist, String type, String filePath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.filePath = filePath;
    }
    public Entity( String name, String artist, String type, String filePath) {
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.filePath = filePath;
    }
    public Entity() {

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
