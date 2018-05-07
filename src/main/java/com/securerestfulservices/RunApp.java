package com.securerestfulservices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
public class RunApp extends SpringBootServletInitializer {
	public static void main(String[] args){
		SpringApplication.run(RunApp.class, args);
	}
	
	// remove this to run as java application
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(RunApp.class);
	}
}