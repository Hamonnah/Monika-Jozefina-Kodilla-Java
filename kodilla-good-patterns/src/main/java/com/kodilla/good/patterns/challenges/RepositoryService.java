package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RepositoryService {

    Map<LocalDateTime, OrderRequest> ordersHistory = new HashMap<>();

    void saveOrderInHistory(OrderRequest orderRequest){
        LocalDateTime orderDate = orderRequest.getOrderDate();
        ordersHistory.put(orderDate,orderRequest);
    }

}
