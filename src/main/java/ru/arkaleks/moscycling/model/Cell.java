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
@Table(name = "CELL")
@Access(AccessType.FIELD)
public class Cell {
    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int globalId;
    @Column(length = 1000000000)
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Type.class)
    private List<Type> type;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = GeoData.class)
    private GeoData geoData;
}
