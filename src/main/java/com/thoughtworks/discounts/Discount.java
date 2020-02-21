package com.thoughtworks.discounts;

import com.thoughtworks.Order;

public interface Discount {
    double calDiscountedPrice(Order order);

    String getDescribe();
    double getFinalPrice();
}
