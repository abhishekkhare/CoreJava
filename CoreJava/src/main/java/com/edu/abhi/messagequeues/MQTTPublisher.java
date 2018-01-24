package com.edu.abhi.messagequeues;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.Date;

public class MQTTPublisher {
	public static void main(String[] args) throws Exception {
		for(int i=0;i<100;i++){
			String messageString = "Hello World from Java!" + new Date(System.currentTimeMillis());
			System.out.println("== START PUBLISHER ==");
			MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
			client.connect();
			MqttMessage message = new MqttMessage();
			message.setPayload(messageString.getBytes());
			client.publish("iot_data", message);
			System.out.println("\tMessage '"+ messageString +"' to 'iot_data'");
			client.disconnect();
			System.out.println("== END PUBLISHER ==");
			Thread.sleep(2000);
		}
	}
}