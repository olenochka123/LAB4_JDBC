package db.lab4.controller.implementation;

import db.lab4.model.implementation.PostOfficeHasDriver;
import db.lab4.service.implementation.PostOfficeHasDriverService;
import db.lab4.service.implementation.GeneralService;

public class PostOfficeHasDriverController extends GeneralController<PostOfficeHasDriver> {
    public static final PostOfficeHasDriverService postOfficeHasDriverService = new PostOfficeHasDriverService();

    @Override
    public GeneralService<PostOfficeHasDriver> getService() {
        return postOfficeHasDriverService;
    }
}
