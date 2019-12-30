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
@Table(name = "DATALENGTH")
@Access(AccessType.FIELD)
public class DataLength {
    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int globalId;
    private int pointNumber;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Coordinate.class)
    private List<Coordinate> coors;

}
