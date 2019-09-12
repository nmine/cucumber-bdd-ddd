package be.nmine.restaurant.orderpicking;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private List<Order> orders = new ArrayList<>();

    public int getValue() {
        int value = 0;
        for(Order order : orders)
            value =+ order.getValue();
        return value;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public int getOrdersSize() {
        return orders.size();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
