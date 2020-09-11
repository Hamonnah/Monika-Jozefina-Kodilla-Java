package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender();
        User user = null;
        try {
            messageSender.sendMessageTo(user, "This is very important message");
        } catch (MessageNotSentException e) {
            System.out.println("Message is not send, " +
                    "but my program still running very well!");
        }

        System.out.println("Processing other logic!");
    }

}
