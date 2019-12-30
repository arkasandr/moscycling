package ru.arkaleks.moscycling.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
@Table(name = "COORDINATE")
@Access(AccessType.FIELD)
public class Coordinate {
    @Id
    @Column(name = "COORDINATE_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
 //  private int id;
    private double coorX;
    private double coorY;
}
