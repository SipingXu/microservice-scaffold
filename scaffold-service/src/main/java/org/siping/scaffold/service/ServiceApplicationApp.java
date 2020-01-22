package org.siping.scaffold.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Siping
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableCaching
public class ServiceApplicationApp {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplicationApp.class,args);
    }
}
