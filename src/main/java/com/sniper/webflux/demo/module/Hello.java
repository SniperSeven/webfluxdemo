package com.sniper.webflux.demo.module;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author Chengyafeng
 * @date 2022/02/12 23:58
 **/
public class Hello {

    @Id
    private String name;

    private Integer age;




    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
