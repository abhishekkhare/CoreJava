package com.edu.abhi.messagequeues;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerTest {

	public static void main(String[] args) {
		Properties configProperties = new Properties();
		configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
		configProperties.put(ConsumerConfig.CLIENT_ID_CONFIG, "simple");

		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(configProperties);
		kafkaConsumer.subscribe(Arrays.asList("HelloKafkaTopic"));
		System.out.println("START CONSUMING");
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out.printf("offset = %d, value = %s", record.offset(), record.value());
				System.out.println();
			}
		}
	}

}