package com.hk.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigCors implements WebMvcConfigurer{

	//CORS 정책 제한 허용
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("http://localhost:8086").allowedMethods("GET","POST","PUT","DELETE")
		.allowedHeaders("*").allowCredentials(false).maxAge(3600); 
	}
}
