package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.DriverDAO;
import db.lab4.model.implementation.Driver;

public class DriverService extends GeneralService<Driver> {
    public GeneralDAOInterface<Driver, Integer> driverDAO = new DriverDAO();

    @Override
    public GeneralDAOInterface<Driver, Integer> getDAO() {
        return driverDAO;
    }

}

