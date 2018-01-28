package org.metarchive.mex.web4mex;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@Configuration
public class Web4MexConfig {
	
	@Bean
	public Web4MexProperties getProperties() {
		return new Web4MexProperties();
	}
	
}
