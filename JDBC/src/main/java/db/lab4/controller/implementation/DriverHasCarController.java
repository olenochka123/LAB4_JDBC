package db.lab4.controller.implementation;

import db.lab4.model.implementation.DriverHasCar;
import db.lab4.service.implementation.DriverHasCarService;
import db.lab4.service.implementation.GeneralService;

public class DriverHasCarController extends GeneralController<DriverHasCar> {
    public static final DriverHasCarService driverHasCarService = new DriverHasCarService();

    @Override
    public GeneralService<DriverHasCar> getService() {
        return driverHasCarService;
    }
}
