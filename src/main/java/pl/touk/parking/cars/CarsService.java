package pl.touk.parking.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.touk.parking.models.Car;

/**
 * Created by martyna on 27.02.18.
 */

@Service
public class CarsService {

    private final CarsRepository carsRepository;

    @Autowired
    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public Car getCarByRegistrationNumber(String registrationNumber){
        return carsRepository
                .findByRegistration(registrationNumber)
                .orElseThrow(() -> new CarNotFoundException(registrationNumber));
    }
}
