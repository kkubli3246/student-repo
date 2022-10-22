package com.cst323.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.*;

@SpringBootApplication
public class Cst323ListApplication {
	
	static Logger log = LoggerFactory.getLogger(Cst323ListApplication.class);
	

	public static void main(String[] args) {
		
		log.info("Started Application");
		SpringApplication.run(Cst323ListApplication.class, args);
		

	}

}
