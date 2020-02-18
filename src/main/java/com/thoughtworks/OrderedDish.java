package com.thoughtworks;

public class OrderedDish extends Dish{
    private int count;

    public OrderedDish(String id, String name, double price, int count) {
        super(id, name, price);
        this.count = count;
    }

    public OrderedDish(Dish dish) {
        super(dish.getId(), dish.getName(), dish.getPrice());
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

//    public double calTotalPrice(){
//        // 用父类构造方法构造后，该属性无法直接被子类使用吗
////        return count * price; //'price' has private access in 'com.thoughtworks.Dish'
//    }
}
