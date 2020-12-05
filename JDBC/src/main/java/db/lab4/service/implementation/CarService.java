package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.CarDAO;
import db.lab4.model.implementation.Car;

public class CarService extends GeneralService<Car> {
    public GeneralDAOInterface<Car, Integer> carDAO = new CarDAO();

    @Override
    public GeneralDAOInterface<Car, Integer> getDAO() {
        return carDAO;
    }

}
