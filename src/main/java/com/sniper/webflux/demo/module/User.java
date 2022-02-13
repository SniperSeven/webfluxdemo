package com.sniper.webflux.demo.module;

import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.data.annotation.Id;

/**
 * @author Chengyafeng
 * @date 2022/02/13 14:25
 **/
public class User {

    @Id
    private String username;
    private String password;
    private String roleName;

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
}
