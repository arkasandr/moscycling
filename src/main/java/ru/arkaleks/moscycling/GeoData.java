package ru.arkaleks.moscycling;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Entity
@Table(name = "GEODATA")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoData {

    @Id
    @Column(name = "GLOBAL_ID", updatable=false, nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int globalId;
    private String type;
    @Column( length = 1000000000 )
    private double[][][] coordinates;

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("coordinates")
    public double[][][] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[][][] coordinates) {
        this.coordinates = coordinates;
    }

    public int getGlobalId() {
        return globalId;
    }

    public void setGlobalId(int globalId) {
        this.globalId = globalId;
    }
}
