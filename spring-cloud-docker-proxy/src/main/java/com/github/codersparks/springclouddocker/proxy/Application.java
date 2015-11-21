package com.github.codersparks.springclouddocker.proxy;

import com.github.codersparks.springclouddocker.eureka.config.EurekaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

/**
 * Created by codersparks on 21/11/2015.
 */
@SpringBootApplication
@EnableZuulProxy
@Import(EurekaConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
