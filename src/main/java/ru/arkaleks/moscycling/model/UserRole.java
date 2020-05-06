package ru.arkaleks.moscycling.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

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
@Table(name = "USERROLE")
public class UserRole implements GrantedAuthority {

    public UserRole(String rolename) {
        this.rolename = rolename;
    }

    @Id
    @Column(name = "USERROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String rolename;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public int getId() {
        return id;
    }

    public String getRolename() {
        return rolename;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    @Override
    public String getAuthority() {
        return getRolename();
    }
}
