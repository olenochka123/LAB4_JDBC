package ua.iot.tfk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iot.tfk.domain.Guide;
import ua.iot.tfk.service.GuideService;
import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/guide")
public class GuideController extends AbstractController<Guide, Integer> {

    @Autowired
    GuideService GuideService;

    @Override
    public ServiceInterface<Guide, Integer> getService() {
        return GuideService;
    }

}
