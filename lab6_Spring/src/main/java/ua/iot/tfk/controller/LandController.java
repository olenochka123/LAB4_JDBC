package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.Land;
import ua.iot.tfk.service.LandService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/land")
public class LandController extends AbstractController<Land, Integer> {

    @Autowired
    LandService LandService;

    @Override
    public ServiceInterface<Land, Integer> getService() {
        return LandService;
    }

}
