package org.siping.scaffold.web;

import org.siping.scaffold.web.config.RabbitConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Siping
 */
@SpringBootApplication
@EnableConfigurationProperties({RabbitConstants.class})
public class WebApplicationApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApplicationApp.class, args);
    }
}
