package ua.iot.tfk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.iot.tfk.dataaccess.GuideRepository;
import ua.iot.tfk.domain.Guide;

@Service
public class GuideService extends GeneralService<Guide, Integer> {

    @Autowired
    GuideRepository GuideRepository;

    @Override
    public JpaRepository<Guide, Integer> getRepository() {
        return GuideRepository;
    }
}
