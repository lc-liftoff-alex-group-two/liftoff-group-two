package org.launchcode.givewise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;


@Getter
@Setter
@Table(name="users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "password")
    private String password;

    public void setPhone(Object phone) {
    }

    public void setPassword(String encoded) {
    }

    public void setEmail(String lowerCase) {
    }

    public void setUserName(Object userName) {
    }
}