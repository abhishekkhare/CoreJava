package com.edu.abhi.messagequeues;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerTest {

	public static void main(String[] args) {
		//Configure the Producer
		Properties configProperties = new Properties();
		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = null;
		try {
			producer = new KafkaProducer<String, String>(configProperties);
			for (int i = 0; i < 100; i++) {
				String msg = "Message " + i;
				producer.send(new ProducerRecord<String, String>("HelloKafkaTopic", msg));
				System.out.println("Sent:" + msg);
				Thread.currentThread().sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}
}