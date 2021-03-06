package org.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced注释掉该注解是因为自己手写了一个轮询的算法，没有使用Ribbon自己的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
