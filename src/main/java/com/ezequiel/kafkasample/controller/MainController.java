package com.vanhack.ezequiel.controller;

import com.vanhack.ezequiel.dto.PersonDto;
import com.vanhack.ezequiel.service.kafka.KafkaProducer;
import com.vanhack.ezequiel.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RequestMapping("api/v1")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("person/create")
    public ResponseEntity<String> customerAuthenticate(@RequestBody PersonDto personDto) {

        logger.info("Requested a new PersonDto");
        try {
            kafkaProducer.send("SEND_PERSON_TOPIC", JsonUtils.convertToJson(personDto));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error during the sent process: " + e.getMessage());
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        logger.info("The PersonDto was sent successfully");
        return new ResponseEntity<>("Sent Successfully", HttpStatus.CREATED);
    }
}