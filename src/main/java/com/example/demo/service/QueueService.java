package com.example.demo.service;

import com.example.demo.helper.ExecutorServiceClass;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.helper.MessageHandler;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

@Service
public class QueueService {

//    @Autowired
    private QueueClient queueClient;

    public QueueService(QueueClient queueClient) {
        this.queueClient = queueClient;
    }

    // reference https://azure.microsoft.com/en-us/services/service-bus/
    public void sendQueueMessage(String content) throws ServiceBusException, InterruptedException {
        final Message message = new Message(content);
        queueClient.send(message);
        System.out.println("Sent!");
    }

    public void receiveQueueMessage() throws ServiceBusException, InterruptedException {
        queueClient.registerMessageHandler(new MessageHandler(), new ExecutorServiceClass());
    }

}
