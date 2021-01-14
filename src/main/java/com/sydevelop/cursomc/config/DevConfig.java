package com.sydevelop.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sydevelop.cursomc.services.BDService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private BDService bdService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean instatiateDatabase() throws ParseException {
		
		if(!"create".equals(strategy)) {
			return false;
		}
		bdService.instatiateDatabase();
		return true;
	}
}
