package ua.iot.tfk.DAO;

import ua.iot.tfk.domain.Hotel;

public class HotelDAO extends BaseDAO<Hotel, Integer> {
    public HotelDAO(){
        super(Hotel.class);
    }
}

