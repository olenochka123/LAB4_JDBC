package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class DriverHasCar implements GeneralModelInterface {
    private Integer driver_id;
    private Integer car_id;

    public DriverHasCar(Integer driver_id, Integer car_id) {
        this.driver_id = driver_id;
        this.car_id = car_id;
    }

    public Integer getDriverId() {
        return driver_id;
    }

    public void setDriverId(Integer driver_id) {
        this.driver_id = driver_id;
    }

    public Integer getCarId() {
        return car_id;
    }

    public void setCarId(Integer car_id) {
        this.car_id = car_id;
    }

    @Override
    public String toString() {
        return "driverHasCar{" +
                "driver_id=" + driver_id +
                ", car_id=" + car_id +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}

