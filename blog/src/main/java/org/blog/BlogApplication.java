package org.blog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("org.blog")
@MapperScan("org.blog")
@EnableScheduling
//@EnableTransactionManagement // 如果mybatis中service实现类中加入事务注解，需要此处添加该注解
public class BlogApplication {
	private static final Logger log = LogManager.getLogger();

	public static void main(String[] args) {
		log.info("Spring boot start ......");
		SpringApplication.run(BlogApplication.class, args);
	}
}
