package pl.touk.parking.stays;

/**
 * Created by martyna on 28.02.18.
 */
public class StayAlreadyStartedException extends RuntimeException {
    public StayAlreadyStartedException(String registrationNumber) {
        super("stay was already started for car with registration number '" + registrationNumber);
    }
}