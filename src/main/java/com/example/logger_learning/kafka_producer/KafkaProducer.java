package com.example.logger_learning.kafka_producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaStringTemplate;

    public void sendStringData(String topic,String message){
        kafkaStringTemplate.send(topic,message);
    }

}
