package com.github.codersparks.springclouddocker.eureka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by codersparks on 21/11/2015.
 */
@Configuration
public class EurekaConfig  {

    @Value("${eureka.instance.ip}")
    private String instanceIP;

    @Value("${eureka.instance.port")
    private int instancePort;

    public EurekaInstanceConfigBean eurekaInstanceConfigBean() {
        EurekaInstanceConfigBean instanceConfigBean = new EurekaInstanceConfigBean();
        instanceConfigBean.setPreferIpAddress(true);
        instanceConfigBean.setIpAddress(instanceIP);
        instanceConfigBean.setNonSecurePort(instancePort);

        return instanceConfigBean;
    }
}
