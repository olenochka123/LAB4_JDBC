package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.StartNextArrival;
import ua.iot.tfk.service.StartNextArrivalService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/start_next_arrival")
public class StartNextArrivalController extends AbstractController<StartNextArrival, Integer> {

    @Autowired
    StartNextArrivalService StartNextArrivalService;

    @Override
    public ServiceInterface<StartNextArrival, Integer> getService() {
        return StartNextArrivalService;
    }

}
