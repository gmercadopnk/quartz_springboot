package com.yrag.helperSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelperSpringBootApplication {

//	private static TareaJdbcInterface tareaJdbcInterface;
//
//	public HelperSpringBootApplication(TareaJdbcInterface tareaJdbcInterface) {
//		this.tareaJdbcInterface = tareaJdbcInterface;
//	}

	public static void main(String[] args) {
		SpringApplication.run(HelperSpringBootApplication.class, args);

//		for (Map<String,Object> map : tareaJdbcInterface.listAll()) {
//			System.out.println("============================> " + map);
//		}
//		tareaJdbcInterface.save("nombre2", "grupo2", "cron2");
	}

}
