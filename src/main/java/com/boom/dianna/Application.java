package com.boom.dianna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Author: lin.xj
 * Date: 2016-09-28
 * Description: 主入口
 */
@SpringBootApplication
@ImportResource("classpath:spring-ctx.xml")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}