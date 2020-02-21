package com.thoughtworks;

import com.thoughtworks.discounts.Discount;
import com.thoughtworks.discounts.OriginalPrice;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Dish> dishes;
    private List<Discount> discounts = new ArrayList<>();

    public Restaurant(List<Dish> dishes) {
        this.dishes = dishes;
        discounts.add(new OriginalPrice());
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public Discount findBestDiscount(Order order) {
        double bestPrice = -1;
        Discount bestDiscount = null;
        for (Discount discount : discounts) {
            double currentPrice = discount.calDiscountedPrice(order);
            if (bestPrice == -1) {
                bestPrice = currentPrice;
                bestDiscount = discount;
            }
            if (currentPrice < bestPrice) {
                bestPrice = currentPrice;
                bestDiscount = discount;
            }
        }
        return bestDiscount;
    }

    public List<Dish> getDishes() {
        return dishes;
    }


    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public String bestCharge(String selectedItems) {
        Order order = parseOrder(selectedItems);
        Discount bestDiscount = findBestDiscount(order);
        return InfoRender.render(order, bestDiscount);
    }

    public static Order parseOrder(String rawOrder) {
        Order order = new Order();
        String[] orderStrings = rawOrder.split(",");
        for (String str : orderStrings) {
            String id = str.split(" x ")[0];
            int count = Integer.parseInt(str.split(" x ")[1]);
            for (Dish dish : DataProvider.getDishes()) {
                if (dish.getId().equals(id)) {
                    OrderedDish orderedDish = new OrderedDish(dish, count);
                    order.getOrderedDishes().add(orderedDish);
                    break;
                }
            }
        }
        return order;
    }
}
