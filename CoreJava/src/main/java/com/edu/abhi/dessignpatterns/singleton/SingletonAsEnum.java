package com.edu.abhi.dessignpatterns.singleton;

import java.util.Date;

public enum SingletonAsEnum {
	INSTANCE;
	
	private  Date connection;

	private SingletonAsEnum()
    {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        // Initialize the connection
        connection = new Date(System.currentTimeMillis());
    }

   

    public Date getConnection()
    {
        return connection;
    }
}
