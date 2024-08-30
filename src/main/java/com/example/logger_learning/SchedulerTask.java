package com.example.logger_learning;

import com.example.logger_learning.utils.CustomLogger;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SchedulerTask {
    private final CustomLogger customLogger;

    @Scheduled(fixedDelay = 60000)
    public void logPrint(){
        customLogger.logError("I am error log.");
    }
}
