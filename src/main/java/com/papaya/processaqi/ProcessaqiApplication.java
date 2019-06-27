package com.papaya.processaqi;

import com.papaya.processaqi.controller.AQIController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@SpringBootApplication
@MapperScan("com.papaya.processaqi.dao")

public class ProcessaqiApplication {

    public static void main(String[] args){
        SpringApplication.run(ProcessaqiApplication.class, args);
    }

}
