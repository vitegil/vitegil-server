package com.vitegil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.vitegil.mapper")
public class VitegilApplication {

    public static void main(String[] args) {
        SpringApplication.run(VitegilApplication.class, args);
    }

}
