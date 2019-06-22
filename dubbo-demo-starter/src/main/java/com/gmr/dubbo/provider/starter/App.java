package com.gmr.dubbo.provider.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.gmr.dubbo.provider")
@ImportResource("classpath:spring/applicationContext.xml")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
