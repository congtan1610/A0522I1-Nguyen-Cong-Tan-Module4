package com.codegym.model;

public class UserInf  extends Day{
    private String name;
    private String year;
    private String gender;
    private String national;
    private String idCard;
    private String vehicle;
    private String idVehicle;
    private String seats;
    private Day departureDay;
    private Day closingDay;
    private String  travelSchedule;

    public UserInf() {
    }

    public UserInf(String name, String year, String gender, String national, String idCard, String vehicle, String idVehicle, String seats, Day departureDay, Day closingDay, String travelSchedule) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.national = national;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.idVehicle = idVehicle;
        this.seats = seats;
        this.departureDay = departureDay;
        this.closingDay = closingDay;
        this.travelSchedule = travelSchedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public Day getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Day departureDay) {
        this.departureDay = departureDay;
    }

    public Day getClosingDay() {
        return closingDay;
    }

    public void setClosingDay(Day closingDay) {
        this.closingDay = closingDay;
    }

    public String getTravelSchedule() {
        return travelSchedule;
    }

    public void setTravelSchedule(String travelSchedule) {
        this.travelSchedule = travelSchedule;
    }
}
