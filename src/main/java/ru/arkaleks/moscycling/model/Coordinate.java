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
@Table(name = "COORDINATE")
@Access(AccessType.FIELD)
public class Coordinate {
    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int globalId;
    private double coorX;
    private double coorY;

}
