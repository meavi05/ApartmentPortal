/**
 * 
 */
package com.apartment.apartmentPortal.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author avi08
 *
 */
@Configuration
public class AppConfig {
	  @Bean
	    public ModelMapper getModalMapper() {
	        return new ModelMapper();
	    }

}
