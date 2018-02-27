package pl.touk.parking.cars;

/**
 * Created by martyna on 27.02.18.
 */
public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String registrationNumber) {
        super("could not find car with registration '" + registrationNumber);
    }

}
