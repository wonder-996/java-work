package com.example.findid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.findid.Mapper")
@SpringBootApplication
public class FindidApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindidApplication.class, args);
    }

}
