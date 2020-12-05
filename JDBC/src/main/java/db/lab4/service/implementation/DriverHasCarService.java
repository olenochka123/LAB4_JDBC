package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.DriverHasCarDAO;
import db.lab4.model.implementation.DriverHasCar;

public class DriverHasCarService extends GeneralService<DriverHasCar> {
    public GeneralDAOInterface<DriverHasCar, Integer> driverHasCarDAO = new DriverHasCarDAO();

    @Override
    public GeneralDAOInterface<DriverHasCar, Integer> getDAO() {
        return driverHasCarDAO;
    }

}

