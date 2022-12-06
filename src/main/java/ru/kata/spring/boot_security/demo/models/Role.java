package ru.kata.spring.boot_security.demo.models;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;


    @ManyToMany(mappedBy = "roles")
    private Set<Person> users;

    public Set<Person> getUsers() {
        return users;
    }

    public void setUsers(Set<Person> users) {
        this.users = users;
    }

    public Role() {
    }


    public Role(String role) {
        this.role = role;
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String name) {
        this.role = name;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}