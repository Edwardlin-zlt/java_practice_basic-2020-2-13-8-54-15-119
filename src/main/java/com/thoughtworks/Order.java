package com.thoughtworks;

import java.util.ArrayList;

public class Order {
    private ArrayList<OrderedDish> orderedDishes = new ArrayList<>();

    public Order() {
    }

    public ArrayList<OrderedDish> getOrderedDishes() {
        return orderedDishes;
    }

}
