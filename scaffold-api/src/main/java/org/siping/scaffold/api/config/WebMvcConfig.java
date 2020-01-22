package org.siping.scaffold.api.config;

import org.siping.scaffold.tools.controller.GlobalDefaultExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Siping
 * @date 2018/5/7 11:37
 * @description
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public GlobalDefaultExceptionHandler handlerExceptionResolver(){
		return new GlobalDefaultExceptionHandler();
	}
}
