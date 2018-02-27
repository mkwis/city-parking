package pl.touk.parking.stays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by martyna on 27.02.18.
 */

@RestController
@RequestMapping("/stays")
public class StaysController {

    private StaysService staysService;

    @Autowired
    public StaysController(StaysService staysService) {
        this.staysService = staysService;
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    StartStayResponseDTO start(@RequestBody StartStayRequestDTO stayRequest){
        StartStayResponseDTO response = staysService.startNewStay(stayRequest.getRegistrationNumber());
        response.add(linkTo(StaysController.class).slash(response.getStayId()).withSelfRel());
        response.add(linkTo(methodOn(StaysController.class).stop(response.getCarRegistration()))
                .withRel("stopStay"));
        response.add(linkTo(methodOn(StaysController.class).charge(response.getCarRegistration()))
                .withRel("getCurrentStayCost"));
        return response;
    }

    @RequestMapping(value = "/stop", method = RequestMethod.POST)
    StopStayResponseDTO stop(@RequestBody String registrationNumber){
        return new StopStayResponseDTO();
    }

    @RequestMapping(value = "/charge", method = RequestMethod.GET)
    ChargeResponseDTO charge(@RequestParam("registrationNumber") String registrationNumber){
        return new ChargeResponseDTO();
    }
}
