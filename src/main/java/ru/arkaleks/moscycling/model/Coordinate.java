package ru.arkaleks.moscycling.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COORDINATE")
public class Coordinate {

    public Coordinate(double coorX, double coorY) {
        this.coorX = coorX;
        this.coorY = coorY;
    }

    @Id
    @Column(name = "COORDINATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double coorX;

    private double coorY;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DATALENGTH_ID")
    private DataLength datalength;
}
