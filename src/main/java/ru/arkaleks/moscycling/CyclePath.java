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
@Table(name = "CYCLEPATH")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CyclePath {

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
}
