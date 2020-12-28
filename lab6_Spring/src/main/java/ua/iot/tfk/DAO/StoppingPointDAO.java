package ua.iot.tfk.DAO;

import ua.iot.tfk.domain.StoppingPoint;

public class StoppingPointDAO extends BaseDAO<StoppingPoint, Integer> {
    public StoppingPointDAO(){
        super(StoppingPoint.class);
    }
}

