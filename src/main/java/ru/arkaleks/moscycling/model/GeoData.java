package ru.arkaleks.moscycling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GEODATA")
@Access(AccessType.FIELD)
public class GeoData {

    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int globalId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = DataLength.class)
    @Column(length = 1000000000)
    private List<DataLength> length;

    @Override
    public String toString() {
        return "GeoData{" +
                "globalId=" + globalId +
                ", length=" + length +
                '}';
    }
}
