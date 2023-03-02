package com.example.furama.model.facility;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity
public class Facility implements Validator {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "not blank")
    @Pattern(regexp = "^[A-Z][a-z0-9]+(\\s[A-Z][a-z0-9]+)*$", message = "name failed")
    private String name;
    @NotNull(message = "not blank")
    private Long area;
    @NotNull(message = "not blank")
    private Double cost;
    @NotNull(message = "not blank")
    private Integer maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    private String facilityFree;
    @ManyToOne
    @JoinColumn(name = "facility_type_id")
    private FacilityType facilityType;
    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    public Facility() {
    }

    public Facility(Long id, String name, Long area, Double cost, Integer maxPeople, String standardRoom, String descriptionOtherConvenience, Double poorArea, Integer numberOfFloors, String facilityFree, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poorArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
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

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poorArea) {
        this.poolArea = poorArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Facility facility = (Facility) target;
        if (facility.facilityType.getName().equals("Villa")) {
            if (facility.standardRoom.isEmpty()) {
                errors.rejectValue("standardRoom", "", "Not Blank");
            }
            if (facility.descriptionOtherConvenience.isEmpty()) {
                errors.rejectValue("descriptionOtherConvenience", "", "Not Blank");
            }
            if (facility.poolArea == null) {
                errors.rejectValue("poolArea", "", "not blank");
            } else if (!facility.poolArea.toString().matches("^([1-9][\\d]*(\\.[\\d]*)?)|(0\\.[\\d]+)$")) {
                errors.rejectValue("poolArea", "", "pool area failed");
            }
            if (facility.numberOfFloors == null) {
                errors.rejectValue("numberOfFloors", "", "not blank");
            } else if (!facility.numberOfFloors.toString().matches("^[1-9][\\d]*$")) {
                errors.rejectValue("numberOfFloors", "", "number of floors failed");
            }
        }
        if (facility.facilityType.getName().equals("House")) {
            if (facility.standardRoom.isEmpty()) {
                errors.rejectValue("standardRoom", "", "Not Blank");
            }
            if (facility.descriptionOtherConvenience.isEmpty()) {
                errors.rejectValue("descriptionOtherConvenience", "", "Not Blank");
            }
            if (facility.numberOfFloors == null) {
                errors.rejectValue("numberOfFloors", "", "not blank");
            } else if (!facility.numberOfFloors.toString().matches("^[1-9][\\d]*$")) {
                errors.rejectValue("numberOfFloors", "", "number of floors failed");
            }
        }
        if (facility.facilityType.getName().equals("Room")) {
            if (facility.facilityFree.isEmpty()) {
                errors.rejectValue("facilityFree", "", "Not Blank");
            }
        }
        if (!(facility.cost==null)&&!facility.cost.toString().matches("^([1-9][\\d]*(\\.[\\d]*)?)|(0\\.[\\d]+)$")) {
            errors.rejectValue("cost", "", "cost failed");
        }
        if (!(facility.maxPeople==null)&&!facility.maxPeople.toString().matches("^[1-9][\\d]*$")) {
            errors.rejectValue("maxPeople", "", "max people failed");
        }
        if (!(facility.area==null)&&!facility.area.toString().matches("^([1-9][\\d]*(\\.[\\d]*)?)|(0\\.[\\d]+)$")) {
            errors.rejectValue("area", "", "area failed");
        }


    }
}
