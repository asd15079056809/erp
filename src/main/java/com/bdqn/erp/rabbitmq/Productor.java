package com.bdqn.erp.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Productor {
    public static void main(String[] args) throws IOException, TimeoutException {
         Connection connection = RabbitmqConnection.getConnection();
          Channel channel = connection.createChannel();
          channel.queueDeclare("hello",false,false,false,null);
          channel.basicPublish("","hello",null,"zhans".getBytes());
          channel.close();
          connection.close();

    }
}
