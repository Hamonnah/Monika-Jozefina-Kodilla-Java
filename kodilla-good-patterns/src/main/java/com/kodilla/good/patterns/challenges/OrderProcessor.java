package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private final InformationService informationService;
    private final OrderService orderService;
    private final RepositoryService repositoryService;

    public OrderProcessor(InformationService informationService, OrderService orderService, RepositoryService repositoryService) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.repositoryService = repositoryService;
    }

    public OrderDto process (final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProductQuantities());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            repositoryService.saveOrderInHistory(orderRequest);
            System.out.println("We are processing your order right at this moment" + "\nDate of order " + orderRequest.getOrderDate());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            System.out.println("Sorry, we can not process your order. Try again");
            return new OrderDto(orderRequest.getUser(), false);
        }
    }

}
