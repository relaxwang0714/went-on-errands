package com.wzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy

public class SpringbootApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(SpringbootApplication.class, args);
        }

}
