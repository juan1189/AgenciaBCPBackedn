package com.bcp.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DbConfig implements WebMvcConfigurer {
	
	private final long MAX_AGE_SECS = 3600;
	
	@Bean
    public String loadDatabase() {
		return "ok";
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("HEAD","OPTIONS","GET","POST","PUT","PATCH","DELETE")
				.maxAge(MAX_AGE_SECS);
	}
	
//	 @Bean
//	    public CorsFilter corsFilter() {
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowCredentials(true);
//	        config.addAllowedOrigin("*");
//	        config.addAllowedHeader("*");
//	        config.addAllowedMethod("OPTIONS");
//	        config.addAllowedMethod("GET");
//	        config.addAllowedMethod("POST");
//	        config.addAllowedMethod("PUT");
//	        config.addAllowedMethod("DELETE");
//	        source.registerCorsConfiguration("/**", config);
//	        return new CorsFilter(source);
//	    }
//	 
//	 @Bean
//	 public WebMvcConfigurer corsConfigurer() {
//	        return new WebMvcConfigurer() {
//	            @Override
//	            public void addCorsMappings(CorsRegistry registry) {
//	                registry.addMapping("/*").allowedOrigins("*");
//	            }
//	        };
//	    }
	
}
