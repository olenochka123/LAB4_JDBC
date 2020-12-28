package ua.iot.tfk.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import ua.iot.tfk.domain.Bus;
        import ua.iot.tfk.service.BusService;
        import ua.iot.tfk.service.ServiceInterface;

@RestController
@RequestMapping("/bus")
public class BusController extends AbstractController<Bus, Integer> {

    @Autowired
    BusService BusService;

    @Override
    public ServiceInterface<Bus, Integer> getService() {
        return BusService;
    }

}
