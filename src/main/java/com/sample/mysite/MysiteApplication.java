package com.sample.mysite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.sample.mysite")
public class MysiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysiteApplication.class, args);
    }

}
