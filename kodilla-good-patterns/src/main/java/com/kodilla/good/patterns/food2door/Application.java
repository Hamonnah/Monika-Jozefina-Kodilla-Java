package food2door;

public class Application {

    public static void main(String[] args) {
        OrderRetriever orderRetriever = new OrderRetriever();
        Order order = orderRetriever.retrieve();
        OrderService service = new OrderService(new InformationMail(), new OrdersRepository(), new OrderProcessor());
        service.order(order);
    }

}


