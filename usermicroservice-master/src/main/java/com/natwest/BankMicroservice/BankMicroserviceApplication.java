package com.natwest.BankMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.natwest.BankMicroservice.userfilter.UserJwtFilter;

//import com.natwest.BankMicroservice.userfilter.UserJwtFilter;

@SpringBootApplication
public class BankMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankMicroserviceApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean getfilter()
	{	
		UrlBasedCorsConfigurationSource urlconfig=new UrlBasedCorsConfigurationSource();
		CorsConfiguration corconfig=new CorsConfiguration();
		corconfig.setAllowCredentials(true);
		corconfig.addAllowedHeader("*");
		corconfig.addAllowedMethod("*");
		corconfig.addAllowedOrigin("*");
		
		urlconfig.registerCorsConfiguration("/**", corconfig);
		FilterRegistrationBean fbean=new FilterRegistrationBean(new CorsFilter(urlconfig));
		
		fbean.setFilter(new UserJwtFilter());
		
		fbean.addUrlPatterns("*");
		
		return fbean;


	}
}
