package com.kodilla.good.patterns.food2door;

public class MailService implements InformationService {

    @Override
    public void inform(Provider provider) {
        System.out.println("Delivery Information email has been sent...");
    }

}
