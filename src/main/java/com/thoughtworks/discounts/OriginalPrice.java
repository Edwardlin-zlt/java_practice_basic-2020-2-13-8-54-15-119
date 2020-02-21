package com.thoughtworks.discounts;

import com.thoughtworks.Order;
import com.thoughtworks.OrderedDish;

public class OriginalPrice implements Discount {
    private Order order;

    public OriginalPrice(Order order) {
        this.order = order;
    }

    @Override
    public double calDiscountedPrice() {
        double totalPrice = 0;
        for (OrderedDish orderedDish : order.getOrderedDishes()) {
            totalPrice += orderedDish.getPrice() * orderedDish.getCount();
        }
        return totalPrice;
    }

    @Override
    public String getDescribe() {
        return "";
    }
}
