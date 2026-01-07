package com.raghav.spring_security_demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.id.IdentityGenerator;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
