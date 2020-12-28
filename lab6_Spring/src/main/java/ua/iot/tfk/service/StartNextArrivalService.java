package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.StartNextArrivalRepository;
import ua.iot.tfk.domain.StartNextArrival;

@Service
public class StartNextArrivalService extends GeneralService<StartNextArrival, Integer> {

    @Autowired
    StartNextArrivalRepository StartNextArrivalRepository;

    @Override
    public JpaRepository<StartNextArrival, Integer> getRepository() {
        return StartNextArrivalRepository;
    }
}
