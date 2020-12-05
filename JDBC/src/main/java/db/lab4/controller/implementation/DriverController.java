package db.lab4.controller.implementation;

import db.lab4.model.implementation.Driver;
import db.lab4.service.implementation.DriverService;
import db.lab4.service.implementation.GeneralService;

public class DriverController extends GeneralController<Driver> {
    public static final DriverService driverService = new DriverService();

    @Override
    public GeneralService<Driver> getService() {
        return driverService;
    }
}