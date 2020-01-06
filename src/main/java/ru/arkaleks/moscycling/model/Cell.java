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
@Table(name = "CELL")
public class Cell {
    @Id
    @Column(name = "CELL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 1000000000)
    @OneToMany(mappedBy = "cell", cascade = CascadeType.ALL)
    private List<PathType> pathType;
    @Column(length = 1000000000)
    @OneToMany(mappedBy = "cell", cascade = CascadeType.ALL)
    private List<DataLength> length;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CYCLEPATH_ID")
    private CyclePath cyclepath;
}
