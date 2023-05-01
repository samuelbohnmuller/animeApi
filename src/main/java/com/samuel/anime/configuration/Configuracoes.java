package com.samuel.anime.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracoes {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
