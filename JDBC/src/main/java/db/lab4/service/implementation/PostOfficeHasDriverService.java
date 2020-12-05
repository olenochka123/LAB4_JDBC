package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.PostOfficeHasDriverDAO;
import db.lab4.model.implementation.PostOfficeHasDriver;

public class PostOfficeHasDriverService extends GeneralService<PostOfficeHasDriver> {
    public GeneralDAOInterface<PostOfficeHasDriver, Integer> postOfficeHasDriverDAO = new PostOfficeHasDriverDAO();

    @Override
    public GeneralDAOInterface<PostOfficeHasDriver, Integer> getDAO() {
        return postOfficeHasDriverDAO;
    }

}