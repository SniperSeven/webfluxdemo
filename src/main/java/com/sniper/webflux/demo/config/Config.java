package com.sniper.webflux.demo.config;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;

/**
  * 
  * @ProductName:    Hundsun HEP
  * @Author:         chengyf36747
  * @CreateDate:     2022-02-16 15:26
  * @Version:        1.0
  *
  * Copyright © 2022 Hundsun Technologies Inc. All Rights Reserved
**/

@Configuration
public class Config {

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return (new R2dbcTransactionManager(connectionFactory));
    }

    @Bean
    public TransactionalOperator transactionalOperator(ReactiveTransactionManager transactionManager) {
        return TransactionalOperator.create(transactionManager);
    }
}
