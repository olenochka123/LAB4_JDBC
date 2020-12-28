package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.TouristDestination;
import ua.iot.tfk.service.TouristDestinationService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/tourist_destination")
public class TouristDestinationController extends AbstractController<TouristDestination, Integer> {

    @Autowired
    TouristDestinationService TouristDestinationService;

    @Override
    public ServiceInterface<TouristDestination, Integer> getService() {
        return TouristDestinationService;
    }

}
