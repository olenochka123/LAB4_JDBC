package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.TourHasStoppingPoint;
import ua.iot.tfk.service.TourHasStoppingPointService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/tour_has_stopping_point")
public class TourHasStoppingPointController extends AbstractController<TourHasStoppingPoint, Integer> {

    @Autowired
    TourHasStoppingPointService TourHasStoppingPointService;

    @Override
    public ServiceInterface<TourHasStoppingPoint, Integer> getService() {
        return TourHasStoppingPointService;
    }

}
