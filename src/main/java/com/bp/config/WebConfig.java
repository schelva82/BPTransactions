package com.bp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.bp.*" })
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
	    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
	    builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    return builder;
	}
	
}
