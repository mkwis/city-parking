package pl.touk.parking.stays;

import org.springframework.data.repository.CrudRepository;
import pl.touk.parking.models.Stay;

/**
 * Created by martyna on 27.02.18.
 */
public interface StaysRepository extends CrudRepository<Stay, Long> {
}
