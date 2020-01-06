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
@Table(name = "PATHTYPE")
public class PathType {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CELL_ID")
    private Cell cell;
}
