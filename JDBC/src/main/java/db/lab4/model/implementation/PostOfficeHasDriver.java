package db.lab4.model.implementation;

import db.lab4.model.GeneralModelInterface;

public class PostOfficeHasDriver implements GeneralModelInterface {
    private Integer post_office_id;
    private Integer driver_id;

    public PostOfficeHasDriver(Integer post_office_id, Integer driver_id) {
        this.post_office_id = post_office_id;
        this.driver_id = driver_id;
    }

    public Integer getPostOfficeId() {
        return post_office_id;
    }

    public void setPostOfficeId(Integer post_office_id) {
        this.post_office_id = post_office_id;
    }

    public Integer getDriverId() {
        return driver_id;
    }

    public void setDriverId(Integer driver_id) {
        this.driver_id = driver_id;
    }

    @Override
    public String toString() {
        return "postOfficeHasDriver{" +
                "post_office_id=" + post_office_id +
                ", driver_id=" + driver_id +
                '}';
    }

    @Override
    public Integer getId() {
        return null;
    }
}
