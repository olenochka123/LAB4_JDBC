package ua.iot.tfk.DAO;

import ua.iot.tfk.domain.Pedestrian;

public class PedestrianDAO extends BaseDAO<Pedestrian, Integer> {
    public PedestrianDAO(){
        super(Pedestrian.class);
    }
}

