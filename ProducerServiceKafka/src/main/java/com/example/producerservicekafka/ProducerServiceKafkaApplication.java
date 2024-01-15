package com.example.producerservicekafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class ProducerServiceKafkaApplication {
    public static void main(String[] args) {
       // SpringApplication.run(ProducerServiceKafkaApplication.class, args);
        Properties properties=new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer"
                );
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer"
                );
        KafkaProducer<String,String> proucer=new KafkaProducer<>(properties)
;
        ProducerRecord<String,String> record=new ProducerRecord<>("example_topic",
                "Clé","Producer message!!!");
        proucer.send(record);
        proucer.close();

    }

}
