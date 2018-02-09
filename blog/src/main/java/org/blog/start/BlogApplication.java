package org.blog.start;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.blog")
@MapperScan("org.blog")
public class BlogApplication {
	 private static final Logger log =	LogManager.getLogger();
	public static void main(String[] args) {
		log.info("Spring boot start ......");
		SpringApplication.run(BlogApplication.class, args);
	}
}
