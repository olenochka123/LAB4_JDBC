package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.Hotel;
import ua.iot.tfk.service.HotelService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/hotel")
public class HotelController extends AbstractController<Hotel, Integer> {

    @Autowired
    HotelService HotelService;

    @Override
    public ServiceInterface<Hotel, Integer> getService() {
        return HotelService;
    }

}
