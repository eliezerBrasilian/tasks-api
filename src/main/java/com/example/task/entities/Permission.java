package com.example.task.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column
    String description;

    @Override
    public String getAuthority() {
        return this.description;
    }

    public String getDescription() {
        return description;
    }
}