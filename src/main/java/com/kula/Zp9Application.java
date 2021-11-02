package com.kula;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// 开启缓存
@EnableCaching
@MapperScan
public class Zp9Application {

	public static void main(String[] args) {
		SpringApplication.run(Zp9Application.class, args);
	}

}
