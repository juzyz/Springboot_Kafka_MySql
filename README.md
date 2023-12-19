# SpringBoot_Kafka_MySql Project

## Overview

This project demonstrates the use of Apache Kafka to build a scalable and distributed messaging system. It includes producers, consumers, and a sample application to showcase Kafka's capabilities. In particular, this project implements functionality for reading real-time stream data from a source and writing it to a MySQL database. The simplified project architecture can be found below.

![SpringKafkaSchema](https://github.com/juzyz/Springboot_Kafka_MySql/assets/96008515/f0538872-9eee-44df-a486-f71a468b491f)

**Data source** is a web service that exposes continuous streams of structured event data. For this project, the Wikimedia EventStreams service is used, with the endpoint https://stream.wikimedia.org/v2/stream/recentchange for retrieving a real-time stream of recent changes made to Wikimedia projects
 
 **Kafka** service and **MySql** database are installed locally on Windows PC.



## Table of Contents

- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Project Structure](#project-structure)
- [Running the Project](#running-the-project)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before running this project, ensure you have the following dependencies installed:

- [Apache Kafka](https://kafka.apache.org/) (version X.X.X)
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version X.X)

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/kafka-project.git
