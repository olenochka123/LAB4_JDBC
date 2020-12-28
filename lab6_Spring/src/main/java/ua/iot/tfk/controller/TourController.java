package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.Tour;
import ua.iot.tfk.service.TourService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/tour")
public class TourController extends AbstractController<Tour, Integer> {

    @Autowired
    TourService TourService;

    @Override
    public ServiceInterface<Tour, Integer> getService() {
        return TourService;
    }

}
