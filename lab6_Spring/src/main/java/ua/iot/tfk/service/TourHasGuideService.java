package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.TourHasGuideRepository;
import ua.iot.tfk.domain.TourHasGuide;

@Service
public class TourHasGuideService extends GeneralService<TourHasGuide, Integer> {

    @Autowired
    TourHasGuideRepository TourHasGuideRepository;

    @Override
    public JpaRepository<TourHasGuide, Integer> getRepository() {
        return TourHasGuideRepository;
    }
}
