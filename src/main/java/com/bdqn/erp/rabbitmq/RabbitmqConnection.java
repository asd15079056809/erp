package com.bdqn.erp.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqConnection {
     private static ConnectionFactory connectionFactory ;
     static{
          connectionFactory=new ConnectionFactory();
          connectionFactory.setHost("192.168.1.7");
          connectionFactory.setVirtualHost("/user");
          connectionFactory.setPort(5672);
          connectionFactory.setUsername("root");
          connectionFactory.setPassword("root");

     }
     public static Connection  getConnection() throws IOException, TimeoutException {
          return connectionFactory.newConnection();
     }
}
