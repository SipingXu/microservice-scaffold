package org.siping.scaffold.api.config;

import org.siping.scaffold.api.config.support.UserService;
import org.siping.scaffold.tools.jwt.JWTAuthenticationFilter;
import org.siping.scaffold.tools.jwt.JWTLoginFilter;
import org.siping.scaffold.tools.result.ResultModel;
import org.siping.scaffold.tools.result.ResultStatus;
import org.siping.scaffold.tools.util.FastJsonUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author Siping
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private JWTAuthenticationSuccessHandler loginAuthenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/**").authenticated()
				.antMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().permitAll().and()
				.addFilterBefore(loginFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public JWTLoginFilter loginFilter() throws Exception {
		JWTLoginFilter loginFilter = new JWTLoginFilter(authenticationManager());
		loginFilter.setSuccessHandler(loginAuthenticationSuccessHandler);
		loginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType("application/json");
            response.getWriter().write(FastJsonUtils
                    .toJSONString(new ResultModel(ResultStatus.FAIL.getCode(), exception.getMessage())));
        });
		return loginFilter;
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setHideUserNotFoundExceptions(false);
		return authenticationProvider;
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		return new UserService();
	}

	@Bean
	public Md5PasswordEncoder passwordEncoder() {
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		passwordEncoder.setIterations(1);
		return passwordEncoder;
	}

}
