package pl.touk.parking.stays;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.touk.parking.cars.CarNotFoundException;

/**
 * Created by martyna on 27.02.18.
 */

@ControllerAdvice
public class StaysControllerAdvice {

    @ResponseBody
    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors carNotFoundExceptionHandler(CarNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(StayAlreadyStartedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    VndErrors stayAlreadyStartedExceptionHandler(StayAlreadyStartedException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}