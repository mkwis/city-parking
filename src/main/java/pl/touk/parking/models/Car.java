package pl.touk.parking.models;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by martyna on 27.02.18.
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String registration;

    @Column
    private String vipLicence;

    @OneToMany(mappedBy = "car")
    private Set<Stay> stays = new HashSet<>();

}
