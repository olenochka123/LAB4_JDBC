package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.LandRepository;
import ua.iot.tfk.domain.Land;

@Service
public class LandService extends GeneralService<Land, Integer> {

    @Autowired
    LandRepository LandRepository;

    @Override
    public JpaRepository<Land, Integer> getRepository() {
        return LandRepository;
    }
}
