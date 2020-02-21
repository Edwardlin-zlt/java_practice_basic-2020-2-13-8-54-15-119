package com.thoughtworks;

import com.thoughtworks.discounts.HalfPriceDishDiscount;
import com.thoughtworks.discounts.ReductionDiscount;

public class App {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant(DataProvider.getDishes());

        HalfPriceDishDiscount halfPriceDishDiscount = new HalfPriceDishDiscount();
        halfPriceDishDiscount.addHalfPriceDishIds(DataProvider.getHalfDishIds());
        restaurant.addDiscount(halfPriceDishDiscount);
        restaurant.addDiscount(new ReductionDiscount());

        String out = restaurant.bestCharge("ITEM0001 x 1,ITEM0013 x 2,ITEM0022 x 1");
        System.out.println(out);

    }

}
