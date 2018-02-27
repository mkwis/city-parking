package pl.touk.parking.stays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touk.parking.cars.CarsService;
import pl.touk.parking.models.Car;
import pl.touk.parking.models.Stay;
import java.time.LocalDateTime;
/**
 * Created by martyna on 27.02.18.
 */

@Service
public class StaysService {

    private final CarsService carsService;
    private final StaysRepository staysRepository;

    @Autowired
    public StaysService(CarsService carsService, StaysRepository staysRepository) {
        this.carsService = carsService;
        this.staysRepository = staysRepository;
    }

    public StartStayResponseDTO startNewStay(String registrationNumber){
        Stay stay = new Stay(LocalDateTime.now(), getCarForStay(registrationNumber));
        return StartStayResponseDTO.fromStay(staysRepository.save(stay));
    }

    private Car getCarForStay(String registrationNumber) {
        return carsService.getCarByRegistrationNumber(registrationNumber);
    }

}
