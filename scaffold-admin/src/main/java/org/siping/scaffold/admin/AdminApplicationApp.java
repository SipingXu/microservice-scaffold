package org.siping.scaffold.admin;

import org.siping.scaffold.admin.config.MyPropsConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Siping
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({MyPropsConstants.class})
public class AdminApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplicationApp.class, args);
    }
}
