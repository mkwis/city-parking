package pl.touk.parking.stays;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;
import pl.touk.parking.models.Stay;

import java.time.LocalDateTime;

/**
 * Created by martyna on 27.02.18.
 */

@Data
@AllArgsConstructor
public class StopStayResponseDTO extends ResourceSupport {

}
