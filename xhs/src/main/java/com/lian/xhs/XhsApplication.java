package com.lian.xhs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lian.xhs.mapper")
public class XhsApplication {

    public static void main(String[] args) {
        SpringApplication.run(XhsApplication.class, args);
    }

}
