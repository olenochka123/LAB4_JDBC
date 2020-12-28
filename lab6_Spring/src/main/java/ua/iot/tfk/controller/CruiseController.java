package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.Cruise;
import ua.iot.tfk.service.CruiseService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/cruise")
public class CruiseController extends AbstractController<Cruise, Integer> {

    @Autowired
    CruiseService CruiseService;

    @Override
    public ServiceInterface<Cruise, Integer> getService() {
        return CruiseService;
    }

}
