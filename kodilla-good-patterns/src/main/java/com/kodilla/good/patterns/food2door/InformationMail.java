package com.kodilla.good.patterns.food2door;

    public class InformationMail implements InformationService {

        @Override
        public void informOrderAccepted(Customer customer) {
            System.out.println(customer.getName() + ", Thank you for your order. We are working on it!");
        }

        @Override
        public void informOrderRejected(Customer customer) {
            System.out.println(customer.getName() + ", Thank you for your order. Sorry, we can't execute your order.");
        }

}
