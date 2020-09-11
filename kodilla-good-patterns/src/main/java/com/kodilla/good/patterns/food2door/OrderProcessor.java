package com.kodilla.good.patterns.food2door;

public class OrderProcessor {

    private final InformationService informationService;
    private final OrderService orderService;

    public OrderProcessor(InformationService informationService, OrderService orderService) {
        this.informationService = informationService;
        this.orderService = orderService;
    }

    public OrderDeliveryDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getProvider());
        if (isOrdered) {
            informationService.inform(orderRequest.getProvider());
            System.out.println("We are processing your delivery " + orderRequest.getQuantityOfOrderedProducts() + " right at this moment" + "\nDate of order " + orderRequest.getOrderDate() );
            return new OrderDeliveryDto(orderRequest.getProvider(), true);
        } else {
            System.out.println("Sorry, we can not process your delivery. Try again");
            return new OrderDeliveryDto(orderRequest.getProvider(), false);
        }
    }

}
