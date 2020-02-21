package com.thoughtworks.discounts;

import com.thoughtworks.DataProvider;
import com.thoughtworks.Order;
import com.thoughtworks.OrderedDish;

import java.util.ArrayList;

public class HalfPriceDishDiscount implements Discount {
    private ArrayList<OrderedDish> halfPriceItems = new ArrayList<>();
    private ArrayList<OrderedDish> fullPriceItems = new ArrayList<>();
    private Order order;
    private double savedAmount;

    public HalfPriceDishDiscount(Order order) {
        this.order = order;
        filterHalfPriceDishes();
        savedAmount = calSavedAmount();
    }

    @Override
    public double calDiscountedPrice() {
        double price = 0;
        for (OrderedDish dish : halfPriceItems) {
            price += dish.getPrice() * 0.5 * dish.getCount();
        }
        for (OrderedDish dish : fullPriceItems) {
            price += dish.getPrice() * dish.getCount();
        }
        return price;
    }

    public void filterHalfPriceDishes() {
        for (OrderedDish dish : order.getOrderedDishes()) {
            boolean nextFlag = false;
            for (String halfPriceDishId : DataProvider.getHalfDishIds()) {
                if (dish.getId().equals(halfPriceDishId)) {
                    halfPriceItems.add(dish);
                    nextFlag = true;
                    break;
                }
            }
            if (nextFlag) {
                continue;
            }
            fullPriceItems.add(dish);
        }
    }

    @Override
    public String getDescribe() {

        StringBuilder out = new StringBuilder("指定菜品半价(");
        for (int i = 0; i < halfPriceItems.size(); i++) {
            if (i == halfPriceItems.size() - 1) {
                out.append(halfPriceItems.get(i).getName());
            } else {
                out.append(halfPriceItems.get(i).getName()).append("，");
            }
        }
        out.append(")，省");
        out.append((int) savedAmount);
        out.append("元");
        return out.toString();
    }

    public double calSavedAmount() {
        double price = 0;
        for (OrderedDish dish : halfPriceItems) {
            price += dish.getPrice() * 0.5 * dish.getCount();
        }
        return price;
    }
}