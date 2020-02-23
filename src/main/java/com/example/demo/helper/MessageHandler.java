package com.example.demo.helper;

import com.microsoft.azure.servicebus.ExceptionPhase;
import com.microsoft.azure.servicebus.IMessage;
import com.microsoft.azure.servicebus.IMessageHandler;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public class MessageHandler implements IMessageHandler {

    public CompletableFuture<Void> onMessageAsync(IMessage message) {
        final String messageString = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println("Received message: " + messageString);
        return CompletableFuture.completedFuture(null);
    }

    public void notifyException(Throwable exception, ExceptionPhase phase) {
        System.out.println(phase + " encountered exception:" + exception.getMessage());
    }

}