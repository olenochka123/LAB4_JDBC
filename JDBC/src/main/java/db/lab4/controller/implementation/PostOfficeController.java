package db.lab4.controller.implementation;

import db.lab4.model.implementation.PostOffice;
import db.lab4.service.implementation.PostOfficeService;
import db.lab4.service.implementation.GeneralService;

public class PostOfficeController extends GeneralController<PostOffice> {
    public static final PostOfficeService postOfficeService = new PostOfficeService();

    @Override
    public GeneralService<PostOffice> getService() {
        return postOfficeService;
    }
}