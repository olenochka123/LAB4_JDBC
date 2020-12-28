package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.City;
import ua.iot.tfk.service.CityService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/city")
public class CityController extends AbstractController<City, Integer> {

    @Autowired
    CityService CityService;

    @Override
    public ServiceInterface<City, Integer> getService() {
        return CityService;
    }

}
