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
@Table(name = "DATALENGTH")
public class DataLength {

    @Id
    @Column(name = "DATALENGTH_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int pointNumber;

    @OneToMany(mappedBy = "datalength", cascade = CascadeType.ALL)
    private List<Coordinate> coors;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CELL_ID")
    private Cell cell;

}
