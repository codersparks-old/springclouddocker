package com.github.codersparks.springclouddocker.eureka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by codersparks on 21/11/2015.
 */
@Configuration
public class EurekaConfig  {

    private static final Logger logger = LoggerFactory.getLogger(EurekaConfig.class);

    @Value("${eureka.instance.ip}")
    private String instanceIP;

    @Value("${eureka.instance.port}")
    private int instancePort;

    @Bean
    @Profile("DEV")
    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        EurekaInstanceConfigBean instanceConfigBean = new EurekaInstanceConfigBean();
        instanceConfigBean.setPreferIpAddress(true);
        logger.info("Setting IP Address to: " + instanceIP);
        instanceConfigBean.setIpAddress(instanceIP);
        logger.info("IP Address set to: " + instanceConfigBean.getIpAddress());
        logger.info("Setting port to: " + instancePort);
        instanceConfigBean.setNonSecurePort(instancePort);
        logger.info("Port set to: " + instanceConfigBean.getNonSecurePort());

        logger.info("Hostname set to: " + instanceConfigBean.getHostname());

        return instanceConfigBean;
    }
}
