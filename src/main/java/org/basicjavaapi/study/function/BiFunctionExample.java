package org.basicjavaapi.study.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionExample {
    public static void main(String[] args) {
        // 创建 BiFunction 实例
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        // 使用 BiFunction
        System.out.println("Addition: " + add.apply(5, 3)); // 输出: Addition: 8
        System.out.println("Multiplication: " + multiply.apply(5, 3)); // 输出: Multiplication: 15
        // 使用 andThen 方法
        // 先进行加法运算，再将结果进行平方操作
        BiFunction<Integer, Integer, Integer> addAndSquare = add.andThen(result -> result * result);
        System.out.println("Addition and Square: " + addAndSquare.apply(5, 3)); // 输出: Addition and Square: 64
    }
}
