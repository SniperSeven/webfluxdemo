package com.sniper.webflux.demo.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @ProductName: Hundsun HEP
 * @Author: chengyf36747
 * @CreateDate: 2022-02-15 14:38
 * @Version: 1.0
 * <p>
 * Copyright © 2022 Hundsun Technologies Inc. All Rights Reserved
 **/
@Component
public class UrlFilter implements WebFilter {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        String urlPath = request.getURI().getPath();

        if (!urlPath.contains("$basicUrl")) {
            return chain.filter(exchange);
        }

        String newUrl = urlPath.replace("$basicUrl", "hello");
        ServerHttpRequest newRequest = request.mutate().path(newUrl).build();
        exchange = exchange.mutate().request(newRequest).build();

        return chain.filter(exchange);
    }
}
