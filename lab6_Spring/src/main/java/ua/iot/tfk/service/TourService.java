package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.TourRepository;
import ua.iot.tfk.domain.Tour;

@Service
public class TourService extends GeneralService<Tour, Integer> {

    @Autowired
    TourRepository TourRepository;

    @Override
    public JpaRepository<Tour, Integer> getRepository() {
        return TourRepository;
    }
}
