package com.bdqn.erp.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Custmar {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitmqConnection.getConnection();
        Channel channel= connection.createChannel();
        channel.exchangeDeclare("fanouts","fanout");
        String quene = channel.queueDeclare().getQueue();
        channel.queueBind(quene,"fanouts","");
        channel.basicConsume(quene,false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("消费者2"+new String(body));
            }
        });
    }
}
