package com.thoughtworks;

public class ReductionDiscount implements Discount{
    private Order order;

    public ReductionDiscount(Order order) {
        this.order = order;
    }

    @Override
    public double calDiscountedPrice() {
        final int reductionPrice = 6;
        double price = new OriginalPrice(order).calDiscountedPrice();
        if (price < 30) {
            return price;
        }
        return price - reductionPrice;
    }

    @Override
    public String getDescribe() {
        return "满30减6元，省6元";
    }
}
