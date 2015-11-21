package com.github.codersparks.springclouddocker.config;

import com.github.codersparks.springclouddocker.eureka.config.EurekaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * Created by codersparks on 21/11/2015.
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@Import(EurekaConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
