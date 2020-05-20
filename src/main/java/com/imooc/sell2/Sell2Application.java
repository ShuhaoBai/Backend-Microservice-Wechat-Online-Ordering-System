package com.imooc.sell2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.sell2.dataobject.mapper")
public class Sell2Application {
    public static void main(String[] args) {
        SpringApplication.run(Sell2Application.class, args);
    }
}

//updated code from cleaning up