package ua.iot.tfk.DAO;

import ua.iot.tfk.domain.Cruise;

public class CruiseDAO extends BaseDAO<Cruise, Integer> {
    public CruiseDAO(){
        super(Cruise.class);
    }
}

