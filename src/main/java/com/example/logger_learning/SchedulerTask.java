package com.example.logger_learning;


import com.example.logger_learning.kafka_producer.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SchedulerTask {
     @Autowired
    KafkaProducer kafkaProducer;

    @Scheduled(fixedDelay = 1000)
    public void logPrint(){
//        log.info("logPrint");
        log.error("logPrint");
//        kafkaProducer.sendStringData("error-topic","error-topic");
    }
}
