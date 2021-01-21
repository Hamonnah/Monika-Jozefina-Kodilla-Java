package com.kodilla.good.patterns.food2door;

public class OrderService {

    private final InformationService informationService;
    private final Repository repository;
    private final OrderProcessor processor;

    public OrderService(InformationService informationService, Repository repository, OrderProcessor processor) {
        this.informationService = informationService;
        this.repository = repository;
        this.processor = processor;
    }

    public void order(Order order) {
        if (processor.process(order)) {
            informationService.informOrderAccepted(order.getCustomer());
            repository.saveOrder(order);
        } else {
            informationService.informOrderRejected(order.getCustomer());
        }
    }

}
