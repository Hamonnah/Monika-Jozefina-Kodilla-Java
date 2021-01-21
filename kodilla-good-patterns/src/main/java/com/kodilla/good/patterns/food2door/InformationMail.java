package com.kodilla.good.patterns.food2door;

    public class MailInfo implements InformationService {

        @Override
        public void informOrderAccepted(Customer customer) {
            System.out.println("Dear " + customer.getName() + " thank you for your order. We start to collect your order, and we will send it within 12 hours.");
        }

        @Override
        public void informOrderRejected(Customer customer) {
            System.out.println("Dear " + customer.getName() + " thank you for your order. Unfortunately we can't execute your order.");
        }

}
