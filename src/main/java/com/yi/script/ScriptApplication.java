package com.yi.script;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 脚本启动程序
 * @author YI
 * @date 2018-4-27 15:12:49
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.yi.script.dao"})
public class ScriptApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScriptApplication.class, args);
	}
}