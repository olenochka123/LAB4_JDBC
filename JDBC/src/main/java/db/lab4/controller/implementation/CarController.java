package db.lab4.controller.implementation;

import db.lab4.model.implementation.Car;
import db.lab4.service.implementation.CarService;
import db.lab4.service.implementation.GeneralService;

public class CarController extends GeneralController<Car> {
    public static final CarService carService = new CarService();

    @Override
    public GeneralService<Car> getService() {
        return carService;
    }
}
