package com.store.digital.supermarket.domain;

import java.time.LocalDateTime;

public class User {

    // ID is can be null as it will set to auto-increment
    private Long id;

    private String username;

    private String firstname;

    private String lastname;

    private LocalDateTime dateJoined = LocalDateTime.now();

    private Role role = Role.CUSTOMER;

    public User(String username, String firstname, String lastname, LocalDateTime dateJoined, Role role, Long id) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateJoined = dateJoined;
        this.role = role;
        this.id = id;
    }
    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDateTime getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDateTime dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
