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
@Table(name = "CELLS")
@Access(AccessType.FIELD)
public class Cells {

    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int globalId;
    private String name;
    private String objectOperOrgPhone;
    private String[] type;
    private double width;
    private String location;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = GeoData.class)
    private GeoData geoData;
    private String departamentalAffiliation;
    private String operOrgName;
    private String portionName;
}
