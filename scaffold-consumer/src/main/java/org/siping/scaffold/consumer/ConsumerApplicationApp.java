package org.siping.scaffold.consumer;

import org.siping.scaffold.consumer.config.RabbitConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Siping
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties({RabbitConstants.class})
public class ConsumerApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicationApp.class, args);
    }
}
