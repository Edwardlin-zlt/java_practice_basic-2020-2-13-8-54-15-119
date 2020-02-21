package com.thoughtworks.discounts;

import com.thoughtworks.Order;
import com.thoughtworks.OrderedDish;

import java.util.ArrayList;
import java.util.List;

public class HalfPriceDishDiscount implements Discount {
    private ArrayList<OrderedDish> halfPriceItems = new ArrayList<>();
    private ArrayList<OrderedDish> fullPriceItems = new ArrayList<>();
    private List<String> halfPriceDishIDs = new ArrayList<>();
    private double savedAmount;
    private double finalPrice;

    public HalfPriceDishDiscount() {
        savedAmount = calSavedAmount();
    }

    public void addHalfPriceDishIds(List<String> ids) {
        halfPriceDishIDs = ids;
    }

    @Override
    public double calDiscountedPrice(Order order) {
        filterHalfPriceDishes(order);
        calSavedAmount();
        for (OrderedDish dish : halfPriceItems) {
            finalPrice += dish.getDish().getPrice() * 0.5 * dish.getCount();
        }
        for (OrderedDish dish : fullPriceItems) {
            finalPrice += dish.getDish().getPrice() * dish.getCount();
        }
        return finalPrice;
    }

    public void filterHalfPriceDishes(Order order) {
        for (OrderedDish dish : order.getOrderedDishes()) {
            boolean nextFlag = false;
            for (String halfPriceDishId : halfPriceDishIDs) {
                if (dish.getDish().getId().equals(halfPriceDishId)) {
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
                out.append(halfPriceItems.get(i).getDish().getName());
            } else {
                out.append(halfPriceItems.get(i).getDish().getName()).append("，");
            }
        }
        out.append(")，省");
        out.append((int) savedAmount);
        out.append("元");
        return out.toString();
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public double calSavedAmount() {
        savedAmount = 0;
        for (OrderedDish dish : halfPriceItems) {
            savedAmount += dish.getDish().getPrice() * 0.5 * dish.getCount();
        }
        return savedAmount;
    }
}
