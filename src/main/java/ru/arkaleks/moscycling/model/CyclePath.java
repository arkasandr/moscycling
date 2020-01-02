package ru.arkaleks.moscycling.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CYCLEPATH")
@Access(AccessType.FIELD)
public class CyclePath {

    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int globalId;
    private int number;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Cell.class)
    private List<Cell> cell;
    private String name;
    private String objectOperOrgPhone;
    private double width;
    private String location;
    private String departamentalAffiliation;
    private String operOrgName;
    private String portionName;

}