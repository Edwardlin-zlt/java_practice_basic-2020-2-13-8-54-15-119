package com.thoughtworks.discounts;

import com.thoughtworks.Order;

public class ReductionDiscount implements Discount {
    double finalPrice;

    public ReductionDiscount() {
    }

    @Override
    public double calDiscountedPrice(Order order) {
        final int reductionPrice = 6;
        double price = new OriginalPrice().calDiscountedPrice(order);
        if (price < 30) {
            return price;
        }
        finalPrice = price - reductionPrice;
        return finalPrice;
    }

    @Override
    public String getDescribe() {
        return "满30减6元，省6元";
    }

    @Override
    public double getFinalPrice() {
        return finalPrice;
    }
}
