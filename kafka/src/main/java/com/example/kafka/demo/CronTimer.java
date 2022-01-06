package com.example.kafka.demo;

import java.util.*;
import javax.annotation.Resource;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: Hannibal
 * @Date: 2020/12/17 17:31
 * @Version 1.0
 * @description
 */
@EnableScheduling
@Component
public class CronTimer {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息
    @Scheduled(cron = "*/2 * * * * ? ")
    public void sendMessage1() {
        System.out.println("________________________");
        for(int i=0;i<5;i++){
            String msg = "Hello," + new Random().nextInt(100);
            System.out.println("发送消息"+msg);
            kafkaTemplate.send("hannibal001", msg);
        }

    }

}
