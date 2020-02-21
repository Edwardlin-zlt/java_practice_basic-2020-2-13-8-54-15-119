package com.thoughtworks;

import com.thoughtworks.discounts.Discount;

public abstract class InfoRender {

    public static String render(Order order, Discount discountType) {
        final String header = "============= 订餐明细 =============\n";
        String itemDetail = renderItemDetail(order);
        String discountInfo = renderDiscountInfo(discountType);
        double finalPrice = discountType.getFinalPrice();
        String totalInfo = "总计：" + (int) finalPrice + "元\n"
            + "===================================";
        return header + itemDetail + discountInfo + totalInfo;
    }

    private static String renderItemDetail(Order order) {
        StringBuilder out = new StringBuilder();
        for (OrderedDish dish : order.getOrderedDishes()) {
            double price = dish.getDish().getPrice() * dish.getCount();
            String tmpString = dish.getDish().getName() + " x " + dish.getCount() + " = " + (int) price + "元\n";
            out.append(tmpString);
        }
        out.append("-----------------------------------\n");
        return out.toString();
    }

    private static String renderDiscountInfo(Discount discountType) {
        if (discountType.getDescribe().equals("")) {
            return "";
        }
        return "使用优惠:\n" + discountType.getDescribe() +
            "\n-----------------------------------\n";
    }
}
