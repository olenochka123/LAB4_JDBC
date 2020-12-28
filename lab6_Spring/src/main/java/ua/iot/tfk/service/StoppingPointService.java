package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.StoppingPointRepository;
import ua.iot.tfk.domain.StoppingPoint;

@Service
public class StoppingPointService extends GeneralService<StoppingPoint, Integer> {

    @Autowired
    StoppingPointRepository StoppingPointRepository;

    @Override
    public JpaRepository<StoppingPoint, Integer> getRepository() {
        return StoppingPointRepository;
    }
}
