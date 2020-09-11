package com.kodilla.patterns.strategy.social;

public class SnapchatPublisher  implements SocialPublisher {

    @Override
    public String share() {
        System.out.println("sharing post on Snapchat...");
        return "Snapchat";
    }

}
