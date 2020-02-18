package com.thoughtworks;

import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public static List<Dish> getDishes() {
        return Arrays.asList(
            new Dish("ITEM0001", "黄焖鸡", 18.00),
            new Dish("ITEM0013", "肉夹馍", 6.00),
            new Dish("ITEM0022", "凉皮", 8.00),
            new Dish("ITEM0030", "冰粉", 2.00));
    }

    public static List<String> getHalfDishIds() {
        return Arrays.asList("ITEM0001", "ITEM0022");
    }
}
