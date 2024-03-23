package org.mustafakaya.odev8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class Odev3Application {

	public static void main(String[] args) {
		SpringApplication.run(Odev3Application.class, args);
	}

}
