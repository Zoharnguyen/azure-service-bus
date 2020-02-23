package com.example.demo.controller;

import com.example.demo.service.QueueService;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueueService queueService;

    @GetMapping("/receive")
    public void receivedMessage() throws InterruptedException, ServiceBusException {
        queueService.receiveQueueMessage();
    }

    @GetMapping("/send")
    public void sendMessage(@RequestParam("content") String content) throws InterruptedException, ServiceBusException {
        queueService.sendQueueMessage(content);
    }

}
