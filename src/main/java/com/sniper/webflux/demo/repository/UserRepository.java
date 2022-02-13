package com.sniper.webflux.demo.repository;

import com.sniper.webflux.demo.module.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chengyafeng
 * @date 2022/02/13 15:00
 **/
@Repository
public interface UserRepository  extends ReactiveCrudRepository<User, String> {


    @Query("select * from user where username = :username")
    User getOne(String username);

}
