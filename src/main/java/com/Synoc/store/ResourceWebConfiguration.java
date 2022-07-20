package com.Synoc.store;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceWebConfiguration implements WebMvcConfigurer{
	//METODO PARA MOSTRAR LAS IMAGENES EN LA HOME-----------------------------
	@Override	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
	}

}
