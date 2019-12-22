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
@Table(name = "CYCLEPATH")
@Access(AccessType.FIELD)
public class CyclePath {

    @Id
    @Column(name = "GLOBAL_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int globalId;
    private int number;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Cells.class)
    private Cells cells;
}
