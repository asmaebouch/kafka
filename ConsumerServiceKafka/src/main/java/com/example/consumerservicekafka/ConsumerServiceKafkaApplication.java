package com.example.consumerservicekafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.retrytopic.DestinationTopic;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

@SpringBootApplication
public class ConsumerServiceKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceKafkaApplication.class, args);

        //Configuration du conommateur
        Properties properties=new Properties();
        properties.put("bootstrap.servers","localhost:9092")
;
properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
properties.put("group.id","example_group");
        Consumer<String,String> consumer=new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("example_topic"));
        while (true){
            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));
            records.forEach(record->{
                System.out.println("Clé:"+record.key()+"Valeur:"+record.value());
            });
        }

    }

}
