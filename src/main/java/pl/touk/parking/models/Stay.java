package pl.touk.parking.models;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import pl.touk.parking.models.utils.LocalDateTimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * Created by martyna on 27.02.18.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime start;

    @Column
    @Setter
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime stop;

    @Column
    @Setter
    private BigInteger costPLN;

    @ManyToOne
    private Car car;

    public Stay(LocalDateTime start, Car car){
        this.start = start;
        this.car = car;
    }
}
