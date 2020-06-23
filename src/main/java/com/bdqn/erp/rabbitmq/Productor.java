package com.bdqn.erp.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Productor {
    public static void main(String[] args) throws IOException, TimeoutException {
         Connection connection = RabbitmqConnection.getConnection();
          Channel channel = connection.createChannel();
          channel.exchangeDeclare("fanouts","fanout");
          channel.basicPublish("fanouts","",null,"这里是fanout模型".getBytes());
          connection.close();

    }
}
