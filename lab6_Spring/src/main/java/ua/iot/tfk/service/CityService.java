package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.CityRepository;
import ua.iot.tfk.domain.City;

@Service
public class CityService extends GeneralService<City, Integer> {

    @Autowired
    CityRepository CityRepository;

    @Override
    public JpaRepository<City, Integer> getRepository() {
        return CityRepository;
    }
}
