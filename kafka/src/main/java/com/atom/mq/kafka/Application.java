package com.atom.mq.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @program: mq-collection-demo
 * @description:
 * @author: Maxxx.Yg
 * @create: 2018-11-19 15:30
 **/
@SpringBootApplication
@EnableKafka
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

}
