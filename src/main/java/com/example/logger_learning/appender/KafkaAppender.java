package com.example.logger_learning.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import lombok.Setter;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaAppender extends AppenderBase<ILoggingEvent> {
    private KafkaProducer<String, String> producer;
    @Setter
    private String bootstrapServers;
    @Setter
    private String topic;


    @Override
    public void start() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        producer = new KafkaProducer<>(props);
        super.start();
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
//        if (iLoggingEvent.getLevel().isGreaterOrEqual(ch.qos.logback.classic.Level.ERROR)) {
            String message = iLoggingEvent.getFormattedMessage();
            producer.send(new ProducerRecord<>(topic, message));
//        }
    }

    @Override
    public void stop() {
        if (producer != null) {
            producer.close();
        }
        super.stop();
    }
}
