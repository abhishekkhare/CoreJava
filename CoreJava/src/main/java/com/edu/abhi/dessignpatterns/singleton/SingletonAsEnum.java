package com.edu.abhi.dessignpatterns.singleton;

import java.util.Date;

public enum SingletonAsEnum {
	INSTANCE;
	
	private final Date connection;

	private SingletonAsEnum()
    {
        // Initialize the connection
        connection = new Date(System.currentTimeMillis());
    }

   

    public Date getConnection()
    {
        return connection;
    }
}
