package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.PostOfficeDAO;
import db.lab4.model.implementation.PostOffice;

public class PostOfficeService extends GeneralService<PostOffice> {
    public GeneralDAOInterface<PostOffice, Integer> postOfficeDAO = new PostOfficeDAO();

    @Override
    public GeneralDAOInterface<PostOffice, Integer> getDAO() {
        return postOfficeDAO;
    }

}