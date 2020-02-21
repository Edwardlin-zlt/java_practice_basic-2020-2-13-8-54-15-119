package com.thoughtworks.discounts;

import com.thoughtworks.Order;
import com.thoughtworks.OrderedDish;

public class OriginalPrice implements Discount {
    private double finalPrice;

    public OriginalPrice() {
    }

    @Override
    public double calDiscountedPrice(Order order) {
        finalPrice = 0;
        for (OrderedDish orderedDish : order.getOrderedDishes()) {
            finalPrice += orderedDish.getDish().getPrice() * orderedDish.getCount();
        }
        return finalPrice;
    }

    @Override
    public String getDescribe() {
        return "";
    }

    @Override
    public double getFinalPrice() {
        return finalPrice;
    }
}
