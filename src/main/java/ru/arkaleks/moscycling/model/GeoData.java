package ru.arkaleks.moscycling.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@Getter
@Setter

@Entity
@Table(name = "GEODATA")
@Access(AccessType.FIELD)
public class GeoData {

    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int globalId;
    private String type;
    @Column(length = 1000000000)
    private double[][][] coordinates;
}
