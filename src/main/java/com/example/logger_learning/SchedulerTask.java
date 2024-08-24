package com.example.logger_learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulerTask {

    @Scheduled(fixedDelay = 1000)
    public void logPrint(){
        log.info("-----logPrint------");
    }
}
