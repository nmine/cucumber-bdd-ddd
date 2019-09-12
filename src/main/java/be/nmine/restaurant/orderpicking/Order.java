package be.nmine.restaurant.orderpicking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order {

    public List<Item> items;
    public int size;

    private int value;

    private Order(List<Item> items) {
        this.items = items;
        this.size = items.size();
    }

    public Order() {
        this.items = new ArrayList<>();
    }

    public static Order from(Item... items) {
        return new Order(Arrays.asList(items));
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public int getValue() {
        items.forEach(item -> this.value += item.value);
        return value;
    }
}
