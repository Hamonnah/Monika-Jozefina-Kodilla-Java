package com.kodilla.patterns.strategy.social;

public class FacebookPublisher implements SocialPublisher {

    @Override
    public String share() {
        System.out.println("sharing post on Facebook...");
        return "Facebook";
    }

}
