package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.BusRepository;
import ua.iot.tfk.domain.Bus;

@Service
public class BusService extends GeneralService<Bus, Integer> {

    @Autowired
    BusRepository BusRepository;

    @Override
    public JpaRepository<Bus, Integer> getRepository() {
        return BusRepository;
    }
}
