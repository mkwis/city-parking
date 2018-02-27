package pl.touk.parking.stays;

import org.springframework.data.repository.CrudRepository;
import pl.touk.parking.models.Stay;

import java.util.Optional;

/**
 * Created by martyna on 27.02.18.
 */
interface StaysRepository extends CrudRepository<Stay, Long> {

    Optional<Stay> findFirstByCarRegistrationAndStopIsNull(String registration);

}
