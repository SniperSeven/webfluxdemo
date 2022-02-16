package com.sniper.webflux.demo.module;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import java.util.StringJoiner;

/**
 * @author Chengyafeng
 * @date 2022/02/13 14:25
 **/
public class User implements Persistable<String> {

    @Id
    private String username;
    private String password;
    private String roleName;

    @Transient
    private boolean isNew;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("roleName='" + roleName + "'")
                .toString();
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String getId() {
        return this.username;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
