package org.siping.scaffold.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Siping
 */
@SpringBootApplication
@EnableEurekaServer
public class ProviderApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationApp.class, args);
    }
}
