package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.TourHasStoppingPointRepository;
import ua.iot.tfk.domain.TourHasStoppingPoint;

@Service
public class TourHasStoppingPointService extends GeneralService<TourHasStoppingPoint, Integer> {

    @Autowired
    TourHasStoppingPointRepository TourHasStoppingPointRepository;

    @Override
    public JpaRepository<TourHasStoppingPoint, Integer> getRepository() {
        return TourHasStoppingPointRepository;
    }
}
