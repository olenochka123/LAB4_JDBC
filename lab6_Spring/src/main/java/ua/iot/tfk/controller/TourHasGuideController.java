package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.TourHasGuide;
import ua.iot.tfk.service.TourHasGuideService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/tour_has_guide")
public class TourHasGuideController extends AbstractController<TourHasGuide, Integer> {

    @Autowired
    TourHasGuideService TourHasGuideService;

    @Override
    public ServiceInterface<TourHasGuide, Integer> getService() {
        return TourHasGuideService;
    }

}
