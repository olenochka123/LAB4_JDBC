package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.StoppingPoint;
import ua.iot.tfk.service.StoppingPointService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/stopping_point")
public class StoppingPointController extends AbstractController<StoppingPoint, Integer> {

    @Autowired
    StoppingPointService StoppingPointService;

    @Override
    public ServiceInterface<StoppingPoint, Integer> getService() {
        return StoppingPointService;
    }

}
