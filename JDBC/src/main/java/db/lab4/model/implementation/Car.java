package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class Car implements GeneralModelInterface {
    private Integer id;
    private String brand;
    private Integer number;
    private String color;

    public Car(Integer id, String brand, Integer number, String color) {
        this.id = id;
        this.brand = brand;
        this.number = number;
        this.color = color;

    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
