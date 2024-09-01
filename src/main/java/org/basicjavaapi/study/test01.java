package org.basicjavaapi.study;

import java.math.BigDecimal;

public class test01 {
    public static void main(String[] args) {
        int k = 4;
        k = k++;
        System.out.println(k);
        double i = 1.0 - 0.9;// 0.9不能精确的表示为2进制小数
        System.out.println(i);
        Float j = 1.0F - 0.9F;//和上面一样的原因
        System.out.println(j);
        // 浮点数的减法要用BigDecimal
        BigDecimal x = new BigDecimal("1.0").subtract(new BigDecimal("0.9"));
        System.out.println(x.floatValue());
        double y = 1.0 - 0.125; //碰巧0.125是一个可以用2进制精确表示的小数，减法可以得到正确结果
        System.out.println(y);

    }
}
