package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.TouristRepository;
import ua.iot.tfk.domain.Tourist;

@Service
public class TouristService extends GeneralService<Tourist, Integer> {

    @Autowired
    TouristRepository TouristRepository;

    @Override
    public JpaRepository<Tourist, Integer> getRepository() {
        return TouristRepository;
    }
}
