package ua.iot.tfk.DAO;

import ua.iot.tfk.domain.Guide;

public class GuideDAO extends BaseDAO<Guide, Integer> {
    public GuideDAO(){
        super(Guide.class);
    }
}

