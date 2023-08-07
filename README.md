## Study Project - SpringBoot + Kafka

## About

This is a project I created in **2018** when I was first learning about Kafka.

This is a simple project running the basics of Kafka but still good content for study.

## Goal

- Create a functional backend application with Kafka Integration

- Be able to produce a message and send it to a consumer when requested

- Learn about Kafka overall (its configuration, behaviors, and points of improvement)

## Stack for this Project

- Java - SpringBoot Framework (MVC Architecture)

- MySql + JPA - Database and data persist

- Swagger - Used for agile endpoint documentation and test

- Kafka - Consumer and Producer

## Install

### Download the repository

  $ git clone https://github.com/eskielsantana/spring-boot-kafka-sample.git

### Download the Kafka 

- Download and install it from the **official website**.

### Run the ZooKeeper and the Kafka Server

  $ cd kafka_directory 
  $ bin\windows\zookeeper-server-start.bat config\zookeeper.properties
  $ bin\windows\kafka-server-start.bat config\server.properties

### Create a topic

- Create a topic with the following command on the Kafka folder _(replace test-topic with any name you prefer)_

  $ bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

- Replace the _**SEND_PERSON_TOPIC**_ value located in the _controller/MainController.java_ and _service/kafka/KafkaConsumer.java_ files by _`test-topic`_ or any name you decided to use

### Generate the jar file

  $ cd spring-boot-kafka-sample && mvn clean install

### Run the application (Windows or MacOS)

  $ java -jar spring-boot-kafka-sample-0.0.1-SNAPSHOT.jar

### Usage

- You can use the Swagger interface to execute a Post request to the "person/create" endpoint and see the consumer receiving the given information

### Swagger

- You can access the web service using the swagger page "[http://localhost:8080/](http://localhost:8080/)"

> **Note:**
>
> This is a project from **2018** and since I am not maintaining it since that year it might have dependencies issues nowadays and the build might fail but still a good content for study

## Author
- Ezequiel Sant'Ana Junior - [LinkedIn](https://www.linkedin.com/in/ezequiel-santana/)
