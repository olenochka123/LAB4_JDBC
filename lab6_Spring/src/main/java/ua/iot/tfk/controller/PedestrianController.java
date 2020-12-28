package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.Pedestrian;
import ua.iot.tfk.service.PedestrianService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/pedestrian")
public class PedestrianController extends AbstractController<Pedestrian, Integer> {

    @Autowired
    PedestrianService PedestrianService;

    @Override
    public ServiceInterface<Pedestrian, Integer> getService() {
        return PedestrianService;
    }

}
