package com.thoughtworks;

import java.util.ArrayList;

public class Order {
    private String rawOrder;
    private ArrayList<OrderedDish> orderedDishes;

    private Order() {
        rawOrder = "";
        orderedDishes = new ArrayList<>();
    }

    public String getRawOrder() {
        return rawOrder;
    }

    public ArrayList<OrderedDish> getOrderedDishes() {
        return orderedDishes;
    }

    public static Order orderParse(String rawOrder){
        Order order = new Order();
        String[] orderStrings = rawOrder.split(",");
        for (String str : orderStrings) {
            String id = str.split(" x ")[0];
            int count = Integer.parseInt(str.split(" x ")[1]);
            for (Dish dish: DataProvider.getDishes()) {
                if (dish.getId().equals(id)) {
                    OrderedDish orderedDish = new OrderedDish(dish);
                    orderedDish.setCount(count);
                    order.orderedDishes.add(orderedDish);
                    break;
                }
            }
        }
        return order;
    }

}
