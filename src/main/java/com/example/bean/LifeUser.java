package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class LifeUser {

    private Integer id;
    private String username;
    private String password;
    private String email;
    
    public LifeUser() {
    }
    
    public LifeUser(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LifeUser [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
    }


}
