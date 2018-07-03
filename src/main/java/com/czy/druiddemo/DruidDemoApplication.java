package com.czy.druiddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource(value={"classpath:application.properties"})
public class DruidDemoApplication extends SpringBootServletInitializer {

	/**
	 * 实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		System.out.println("Project start ...");
		builder.sources(this.getClass());
		return super.configure(builder);
	}

	public static void main(String[] args) {
		SpringApplication.run(DruidDemoApplication.class, args);
	}
}
