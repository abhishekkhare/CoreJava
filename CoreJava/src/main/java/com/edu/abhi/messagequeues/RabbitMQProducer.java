package com.edu.abhi.messagequeues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQProducer {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		for(int i=0; i<100 ; i++){
			String message = "Hello World!" + new java.util.Date(System.currentTimeMillis());
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
			Thread.sleep(2000);
		}
		channel.close();
		connection.close();
	}
}
