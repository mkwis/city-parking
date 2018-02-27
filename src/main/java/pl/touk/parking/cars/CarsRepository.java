package pl.touk.parking.cars;

import org.springframework.data.repository.CrudRepository;
import pl.touk.parking.models.Car;

import java.util.Optional;

/**
 * Created by martyna on 27.02.18.
 */

interface CarsRepository extends CrudRepository<Car, Long> {

    Optional<Car> findByRegistration(String registration);

}
