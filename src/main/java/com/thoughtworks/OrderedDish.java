package com.thoughtworks;

import java.util.Objects;

public class OrderedDish {
    private Dish dish;
    private int count;

    public OrderedDish(Dish dish, int count) {
        this.dish = dish;
        this.count = count;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedDish that = (OrderedDish) o;
        return Objects.equals(dish.getId(), that.dish.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dish);
    }

    public void setCount(int count) {
        this.count = count;
    }
}
