package ru.arkaleks.moscycling.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CYCLEPATH")
public class CyclePath {

    public CyclePath(int id, int number, String name, String objectPhone, double width, String location,
                     String departamentalAffiliation, String orgName, String portionName) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.objectPhone = objectPhone;
        this.width = width;
        this.location = location;
        this.departamentalAffiliation = departamentalAffiliation;
        this.orgName = orgName;
        this.portionName = portionName;
    }

    @Id
    @Column(name = "CYCLEPATH_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cycle_path_seq")
    @SequenceGenerator(name = "cycle_path_seq", sequenceName = "cycle_path_seq", allocationSize = 10)
    private int id;

    private int number;

    @OneToMany(mappedBy = "cyclepath", cascade = CascadeType.ALL)
    private List<Cell> cell;

    private String name;

    private String objectPhone;

    private double width;

    private String location;

    private String departamentalAffiliation;

    private String orgName;

    private String portionName;


}