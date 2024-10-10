package com.tns.B90_User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class UserEntity {

    @Id
    private Integer userid;
    private String username;
    private String email;
    private String password;
    private String role;

    public UserEntity() {}

    public UserEntity(Integer userid, String username, String email, String password, String role) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserEntity [userid=" + userid + ", username=" + username + ", email=" + email
                + ", password=" + password + ", role=" + role + "]";
    }
}