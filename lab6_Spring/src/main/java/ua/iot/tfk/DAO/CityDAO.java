package ua.iot.tfk.DAO;

import ua.iot.tfk.domain.City;

public class CityDAO extends BaseDAO<City, Integer> {
    public CityDAO(){
        super(City.class);
    }
}

