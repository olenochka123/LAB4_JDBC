package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.HotelRepository;
import ua.iot.tfk.domain.Hotel;

@Service
public class HotelService extends GeneralService<Hotel, Integer> {

    @Autowired
    HotelRepository HotelRepository;

    @Override
    public JpaRepository<Hotel, Integer> getRepository() {
        return HotelRepository;
    }
}
