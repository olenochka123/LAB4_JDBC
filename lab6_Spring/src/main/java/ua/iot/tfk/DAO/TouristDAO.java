package ua.iot.tfk.DAO;

import ua.iot.tfk.domain.Tourist;

public class TouristDAO extends BaseDAO<Tourist, Integer> {
    public TouristDAO(){
        super(Tourist.class);
    }
}

