package com.example.logger_learning.utils;

import com.example.logger_learning.kafka_producer.KafkaProducer;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
@AllArgsConstructor
public class CustomLogger {
//    private final KafkaProducer kafkaProducer;
//    private Logger getLogger() {
//        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//        // 3rd element in the stack trace should be the caller of the log method
//        String className = stackTrace[3].getClassName();
//        return LoggerFactory.getLogger(className);
//    }

    private final KafkaProducer kafkaProducer;
    private final Map<String, Logger> loggerCache = new ConcurrentHashMap<>();

    private Logger getLogger() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        return loggerCache.computeIfAbsent(className, LoggerFactory::getLogger);
    }

    public void logInfo(String message) {
        Logger logger = getLogger();
        logger.info(message);
    }

    public void logError(String message) {
        Logger logger = getLogger();
        logger.error(message);
        kafkaProducer.sendStringData("error-topic", message);
    }

    public void logDebug(String message) {
        Logger logger = getLogger();
        logger.debug(message);
    }

    public void logWarn(String message) {
        Logger logger = getLogger();
        logger.warn(message);
    }
}
