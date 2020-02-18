package com.thoughtworks;

public class App {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        String order1 = "ITEM0001 x 1,ITEM0013 x 2,ITEM0022 x 1";
        String order2 = "ITEM0013 x 4,ITEM0022 x 1";
        String order3 = "ITEM0013 x 4";
        System.out.println(restaurant.bestCharge(order1));
        System.out.println(restaurant.bestCharge(order2));
        System.out.println(restaurant.bestCharge(order3));
    }
}
