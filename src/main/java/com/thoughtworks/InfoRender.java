package com.thoughtworks;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

public abstract class InfoRender {

    public static String render(Order order, Discount discountType, double finalPrice) {
        final String header = "============= 订餐明细 =============\n";
        String itemDetail = renderItemDetail(order);
        String discountInfo = renderDiscountInfo(discountType);
        String totalInfo = "总计：" + (int) finalPrice + "元\n"
            + "===================================";
        return header + itemDetail + discountInfo + totalInfo;
    }

    private static String renderItemDetail(Order order) {
        StringBuilder out = new StringBuilder();
        for (OrderedDish dish : order.getOrderedDishes()) {
            double price = dish.getPrice() * dish.getCount();
            String tmpString = dish.getName() + " x " + dish.getCount() + " = " + (int) price + "元\n";
            out.append(tmpString);
        }
        out.append("-----------------------------------\n");
        return out.toString();
    }

    private static String renderDiscountInfo(Discount discountType) {
        if (discountType.getDescribe().equals("")){
            return "";
        }
        return "使用优惠:\n" + discountType.getDescribe() +
            "\n-----------------------------------\n";
    }
}
