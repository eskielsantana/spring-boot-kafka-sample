package com.vanhack.ezequiel.service.kafka;

import com.vanhack.ezequiel.dto.PersonDto;
import com.vanhack.ezequiel.util.JsonUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer{

    private final static String topic = "SEND_PERSON_TOPIC";

    @KafkaListener(topics = topic)
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        try {
            PersonDto personDto = (PersonDto) JsonUtils.convertToObject((String) consumerRecord.value(), PersonDto.class);

            System.out.println("Kafka Consumer received a new person coming from " + topic + " topic.");
            System.out.println("PersonDto: " + personDto.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}