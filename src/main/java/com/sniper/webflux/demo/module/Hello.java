package com.sniper.webflux.demo.module;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import java.util.StringJoiner;

/**
 * 
 * @author Chengyafeng
 * @date 2022/02/12 23:58
 **/
public class Hello implements Persistable<String> {

    @Id
    private String name;

    private Integer age;

    @Transient
    private boolean isNew;

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

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Hello.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }

    @Override
    public String getId() {
        return this.name;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
