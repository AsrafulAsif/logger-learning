package com.example.logger_learning.scheduler;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class SchedulerTask {

    @Scheduled(fixedDelay = 1000)
    public void errorLogProvider(){
        log.error("I am error log");
    }
}
