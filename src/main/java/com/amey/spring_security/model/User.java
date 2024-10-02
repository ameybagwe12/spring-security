package com.amey.spring_security.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
}
