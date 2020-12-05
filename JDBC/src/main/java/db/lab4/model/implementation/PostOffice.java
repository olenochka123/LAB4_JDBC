package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class PostOffice implements GeneralModelInterface {
    private Integer id;
    private Integer capacity;
    private String phone_number;
    private String hours_of_working;

    public PostOffice(Integer id, Integer capacity, String phone_number, String hours_of_working) {
        this.id = id;
        this.capacity = capacity;
        this.phone_number = phone_number;
        this.hours_of_working = hours_of_working;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHoursOfWorking() {
        return hours_of_working;
    }

    public void setHoursOfWorking(String hours_of_working) {
        this.hours_of_working = hours_of_working;
    }

    @Override
    public String toString() {
        return "PostOffice{" +
                "id=" + id +
                ", capacity='" + capacity + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", hours_of_working='" + hours_of_working + '\'' +
                '}';
    }
}

