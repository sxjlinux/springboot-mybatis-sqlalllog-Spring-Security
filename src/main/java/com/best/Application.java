package com.best;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author:sunxj
 * @date:2020-11-10 21:46:43
 * @description:
 */
@SpringBootApplication
@MapperScan({"com.best.mapper"})//如果有多个可以使用{"com.best.dao","com.best.sss.dao"}
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

