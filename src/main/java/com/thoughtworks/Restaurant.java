package com.thoughtworks;

public class Restaurant {

    public String bestCharge(String selectedItems) {
        Order order = Order.orderParse(selectedItems);
        OriginalPrice noDiscount = new OriginalPrice(order);
        ReductionDiscount reductionDiscount = new ReductionDiscount(order);
        HalfPriceDishDiscount halfPriceDishDiscount = new HalfPriceDishDiscount(order);
        double originalPrice = noDiscount.calDiscountedPrice();
        double finalPrice = originalPrice;
        Discount discountType = noDiscount;

        if (originalPrice >= 30) {
            finalPrice = reductionDiscount.calDiscountedPrice();
            discountType = reductionDiscount;
        }
        double halfPriceDishPrice = halfPriceDishDiscount.calDiscountedPrice();
        if (halfPriceDishPrice < finalPrice) {
            finalPrice = halfPriceDishPrice;
            discountType = halfPriceDishDiscount;
        }

        return InfoRender.render(order, discountType, finalPrice);
    }
}
