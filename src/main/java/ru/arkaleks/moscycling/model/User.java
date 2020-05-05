package ru.arkaleks.moscycling.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "USERDATA")
public class User {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//  @ManyToMany(cascade = {
//          CascadeType.PERSIST,
//          CascadeType.MERGE
//  })
//    @JoinTable(
//            name = "USERROLE",
//            joinColumns = { @JoinColumn(name = "USER_ID") },
//            inverseJoinColumns = { @JoinColumn(name = "USERROLE_ID") }
//    )
    private List<UserRole> userRole;

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }
}
