package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.PedestrianRepository;
import ua.iot.tfk.domain.Pedestrian;

@Service
public class PedestrianService extends GeneralService<Pedestrian, Integer> {

    @Autowired
    PedestrianRepository PedestrianRepository;

    @Override
    public JpaRepository<Pedestrian, Integer> getRepository() {
        return PedestrianRepository;
    }
}
