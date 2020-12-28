package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.TouristDestinationRepository;
import ua.iot.tfk.domain.TouristDestination;

@Service
public class TouristDestinationService extends GeneralService<TouristDestination, Integer> {

    @Autowired
    TouristDestinationRepository TouristDestinationRepository;

    @Override
    public JpaRepository<TouristDestination, Integer> getRepository() {
        return TouristDestinationRepository;
    }
}
