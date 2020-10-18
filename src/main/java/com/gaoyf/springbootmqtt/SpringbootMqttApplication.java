package com.gaoyf.springbootmqtt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@SpringBootApplication
//@MapperScan("com.gaoyf.domain")
@ComponentScan(basePackages = {"com.gaoyf.mqtt.controller", "com.gaoyf.mqtt.core"})
public class SpringbootMqttApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMqttApplication.class, args);
    }

}
