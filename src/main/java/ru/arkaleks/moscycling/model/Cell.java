package ru.arkaleks.moscycling.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alex Arkashev (arkasandr@gmail.com)
 * @version $Id$
 * @since 0.1
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CELL")
public class Cell {

    public Cell(int id, CyclePath cyclepath) {
        this.id = id;
        this.cyclepath = cyclepath;
    }

    @Id
    @Column(name = "CELL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 1000000000)
    @OneToMany(mappedBy = "cell", cascade = CascadeType.ALL)
    private List<PathType> pathType;
    @Column(length = 1000000000)
    @OneToMany(mappedBy = "cell", cascade = CascadeType.ALL)
    private List<DataLength> length;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CYCLEPATH_ID")
    private CyclePath cyclepath;
}
