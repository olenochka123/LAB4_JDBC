package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.CruiseRepository;
import ua.iot.tfk.domain.Cruise;

@Service
public class CruiseService extends GeneralService<Cruise, Integer> {

    @Autowired
    CruiseRepository CruiseRepository;

    @Override
    public JpaRepository<Cruise, Integer> getRepository() {
        return CruiseRepository;
    }
}
