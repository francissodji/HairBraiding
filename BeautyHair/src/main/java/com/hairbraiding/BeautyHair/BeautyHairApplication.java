package com.hairbraiding.BeautyHair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.hairbraiding.model")
@EnableJpaRepositories("com.hairbraiding.dao")
public class BeautyHairApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautyHairApplication.class, args);
	}

	
	@Configuration
	public class CorsConfiguration {

	    @SuppressWarnings("deprecation")
		@Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurerAdapter() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                        .allowedMethods("*")
	                        .allowedOrigins("http://localhost:4200");
	            }
	        };
	    }
	}
	 
	
}
