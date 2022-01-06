package com.example.kafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Hannibal
 * @Date: 2021/2/3 18:00
 * @Version 1.0
 * @description
 */
@Component
public class SimpleConsumer {

        // 消费监听
        @KafkaListener(topics = "hannibal001")
        public void onMessage1(ConsumerRecord<?, ?> record){
            // 消费的哪个topic、partition的消息,打印出消息内容
            System.out.println("消费消息："+record.topic()+"-"+record.partition()+"-"+record.value());
        }
}
