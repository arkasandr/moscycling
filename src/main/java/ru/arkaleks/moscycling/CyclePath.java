package ru.arkaleks.moscycling;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.PI;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */


@Entity
@Table(name = "CYCLEPATH")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CyclePath {

//    public CyclePath(int number, Cells cells) {
//        this.number = number;
//        this.cells = cells;
//    }

    @Id
    @Column(name = "GLOBAL_ID", updatable=false, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int globalId;
    private int number;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Cells.class)
  //  @JoinTable(name = "CELLS", joinColumns = { @JoinColumn(name = "CYCLEPATH_ID") }, inverseJoinColumns = { @JoinColumn(name = "CELL_ID") })
    private Cells cells;

    @JsonProperty("Cells")
    public Cells getCells() {
        return cells;
    }

    public void setCells(Cells cells) {
        this.cells = cells;
    }

    @JsonProperty("global_id")
    public int getGlobalId() {
        return globalId;
    }

    public void setGlobalId(int globalId) {
        this.globalId = globalId;
    }

    @JsonProperty("Number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public double getCyclePathLength(CyclePath cyclePath) {
        double result;
        List<Double> sum = new ArrayList<>();
        List<Double> coordinates = new ArrayList<>();
        double path = 0;
        for (int i = 0; i < cyclePath.getCells().getGeoData().getCoordinates().length; i++) {
            List<Double> temp = new ArrayList<>();
            for (int k = 0; k < cyclePath.getCells().getGeoData().getCoordinates()[i].length; k++) {
                for (int l = 0; l < cyclePath.getCells().getGeoData().getCoordinates()[i][k].length; l++) {
                    coordinates.add(cyclePath.getCells().getGeoData().getCoordinates()[i][k][l]);
                }
                double lensum = 0;
                Double[] coor = new Double[coordinates.size()];
                coordinates.toArray(coor);
                for (int m = 0; m < coor.length - 2; m++) {
                    double length;
                    length = 2 * 6371 * asin(sqrt(pow((sin(((coor[m + 3]) * PI / 180
                            - (coor[m + 1] * PI / 180)) / 2)), 2) + cos((coor[m + 1]) * PI / 180)
                            *  cos((coor[m + 3]) * PI / 180) * (pow((sin(((coor[m + 2]) * PI / 180
                            - (coor[m] * PI / 180)) / 2)), 2))));
                    lensum = lensum + length;
                    m = m + 1;
                }
                temp.add(lensum);
                path = temp.get(temp.size() - 1);
            }
        }
        return path;
    }
}
