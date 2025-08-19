package com.chiron.springbootbyshreyansh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class SpringbootbyshreyanshApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbyshreyanshApplication.class, args);
	}

}
