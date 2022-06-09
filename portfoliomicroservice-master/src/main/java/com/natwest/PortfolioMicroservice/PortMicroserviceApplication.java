package com.natwest.PortfolioMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.natwest.PortfolioMicroservice.filters.Portfoliofilter;
//import com.stackroute.travelsapp.filter.TravelJwtFilter;
@SpringBootApplication
public class PortMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortMicroserviceApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean  getfilter()
	{
		UrlBasedCorsConfigurationSource urlconfig=new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corconfig=new CorsConfiguration();
		
		corconfig.setAllowCredentials(true);
		corconfig.addAllowedOrigin("*");
		corconfig.addAllowedMethod("*");
		corconfig.addAllowedHeader("*");
		
		urlconfig.registerCorsConfiguration("/**", corconfig);
		
		FilterRegistrationBean fbean=new FilterRegistrationBean(new CorsFilter(urlconfig));
		
		fbean.setFilter(new Portfoliofilter());
		
		fbean.addUrlPatterns("*");
		
		return fbean;
		
		
	}

}
