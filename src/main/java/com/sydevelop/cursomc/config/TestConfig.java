package com.sydevelop.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sydevelop.cursomc.services.BDService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private BDService bdService;

	@Bean
	public boolean instatiateDatabase() throws ParseException {
		bdService.instatiateDatabase();
		return true;
	}
}
