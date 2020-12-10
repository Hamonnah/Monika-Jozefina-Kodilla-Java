package com.kodilla.good.patterns.food2door;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderProcessor {

    private final InformationService informationService;
    private final OrderService orderService;

    public OrderProcessor(InformationService informationService, OrderService orderService) {
        this.informationService = informationService;
        this.orderService = orderService;
    }

    public OrderDeliveryDto process(OrderRequest orderRequest) {
        List<Provider> providers = orderRequest.getQuantityOfOrderedProducts().keySet().stream()
                .map(Product::getShop)
                .distinct()
                .collect(Collectors.toList());
        for (Provider provider : providers) {
            Map<Product, Integer> shopProducts = orderRequest.quantityOfOrderedProducts.entrySet().stream()
                    .filter(entry -> entry.getKey().getShop().equals(provider))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            provider.order(shopProducts);
        }

       /* boolean isOrdered = orderService.order(orderRequest);
        if (isOrdered) {
            informationService.inform(orderRequest.getProvider());
            System.out.println("We are processing your delivery " + orderRequest.getQuantityOfOrderedProducts() + " right at this moment" + "\nDate of order " + orderRequest.getOrderDate() );
            return new OrderDeliveryDto(orderRequest.getProvider(), true);
        } else {
            System.out.println("Sorry, we can not process your delivery. Try again");
            return new OrderDeliveryDto(orderRequest.getProvider(), false);
        }
    }*/
        return null;
    }

}
