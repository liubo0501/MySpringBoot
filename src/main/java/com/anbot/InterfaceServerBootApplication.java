package com.anbot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.anbot")
public class InterfaceServerBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterfaceServerBootApplication.class, args);
	}
}
