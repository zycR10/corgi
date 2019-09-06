package org.zeason.corgi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zeason.corgi.dto.MetaDataDTO;

@SpringBootApplication
public class CorgiApplication {

	public static void main(String[] args) {
		MetaDataDTO dto = new MetaDataDTO();
		SpringApplication.run(CorgiApplication.class, args);
	}

}
