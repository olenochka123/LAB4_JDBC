package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.Tourist;
import ua.iot.tfk.service.TouristService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/tourist")
public class TouristController extends AbstractController<Tourist, Integer> {

    @Autowired
    TouristService TouristService;

    @Override
    public ServiceInterface<Tourist, Integer> getService() {
        return TouristService;
    }

}
