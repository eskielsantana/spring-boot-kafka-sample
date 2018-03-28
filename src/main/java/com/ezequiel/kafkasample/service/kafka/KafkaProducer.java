package com.vanhack.ezequiel.service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    private static KafkaProducer kafkaProducer;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

//    public static KafkaProducer getInstance(){
//        if(kafkaProducer == null){
//            kafkaProducer = new KafkaProducer();
//        }
//        return kafkaProducer;
//    }

    public void send(String topic, String payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }

}
