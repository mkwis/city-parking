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
public class StartStayResponseDTO extends ResourceSupport {

    private Long stayId;
    private String carRegistration;
    private LocalDateTime parkingStart;

    public static StartStayResponseDTO fromStay(Stay stay){
        return new StartStayResponseDTO(stay.getId(), stay.getCar().getRegistration(), stay.getStart());
    }

}
