# SpringBoot_Kafka_MySql Project

## Overview
**Apache Kafka** is a publish-subscribe based *durable messaging system*. A messaging system sends messages between processes, applications, and servers. Apache Kafka is a software where topics can be defined (think of a topic as a category), applications can add, process and reprocess records.

This project demonstrates the use of **Apache Kafka** to build a scalable and distributed messaging system. It includes producers, consumers, and a sample application to showcase Kafka's capabilities. In particular, this project implements functionality for reading real-time stream data from a source and writing it to a **MySQL** database. The simplified project architecture can be found below.

![SpringKafkaSchema](https://github.com/juzyz/Springboot_Kafka_MySql/assets/96008515/f0538872-9eee-44df-a486-f71a468b491f)

**Data source** is a web service that exposes continuous streams of structured event data. For this project, the Wikimedia EventStreams service is used, with the endpoint https://stream.wikimedia.org/v2/stream/recentchange for retrieving a real-time stream of recent changes made to Wikimedia projects
 
 **Kafka** service and **MySql** database are installed locally on Windows PC.

SpringBoot version is 3.2.0.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Configuration](#configuration)
- [Running the Project](#running-the-project)- 
- [Contributing](#contributing)


## Prerequisites

Before running this project, ensure you have the following dependencies installed:

- [Apache Kafka](https://kafka.apache.org/) (version 3.6.0)
- [MySQL database](https://www.mysql.com/) (version 8.1.0)
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 17)
- [Apache Maven](https://maven.apache.org/) (version 3.8.1)


## Setup

1. Clone the repository:
  ```bash
  git clone  https://github.com/juzyz/Springboot_Kafka_MySql.git
  ```
 
2. Navigate to the project directory:

  ```bash
  cd Springboot_Kafka_MySql
  ```

3. Build the project using Maven:
   
  ```bash
  mvn clean install
  ```
4. Create wikimedia schema in MySql db:
   
  ```bash
CREATE SCHEMA `wikimedia`;
  ```

## Configuration

1. Configure the MySql database connection in src/main/resources/application.properties in springboot-kafka-mysql module:

```
spring.datasource.url=jdbc:mysql://localhost:3306/wikimedia?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```
2. Configure the Kafka connection in src/main/resources/application.properties in springboot-kafka-mysql and kafka-producer-wikimedia modules:

```
spring.kafka.consumer.boostrap-servers: localhost:9092
spring.kafka.consumer.group-id: myGroup
spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.topic.name=wikimedia_recentchange
```

## Running the Project

1. Start Zookeeper (if not already running) from the kafka directory  

  ```bash
  .\bin\windows\zookeeper-server-start.bat config\zookeeper.properties
   ```

2. Start Kafka: 

 ```bash
  .\bin\windows\kafka-server-start.bat config\server.properties
   ```

3. Run producers:

Navigate to  kafka-producer-wikimedia module and run SpringBootProducerApplication.java class.

```bash
 mvn spring-boot:run -DmainClass=com.juzyz.springboot.SpringBootProducerApplication
```

4. Run consumers:

Navigate to kafka-consumer-database module and run SpringBootConsumerApplication.java class.
```bash
 mvn spring-boot:run -DmainClass=com.juzyz.springboot.SpringBootConsumerApplication
```

### Results
![kafkaProjectWorkFlow](https://github.com/juzyz/Springboot_Kafka_MySql/assets/96008515/aae19f47-e398-42f7-a8ba-af91d9794a6d)

## Contributing
Feel free to contribute to this project by opening issues or submitting pull requests. Follow the [contribution guidelines](https://github.com/jessesquires/.github/blob/main/CONTRIBUTING.md ) for more details.
