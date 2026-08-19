package cn.hytc.mysql;

import java.util.*;
import java.util.stream.*;
class test {
    public static void main(String[] args) {
        // 1. 字符串列表（用于题1、题4）
        List<String> cities = Arrays.asList("Shanghai", "Beijing", "NewYork", "Paris");

        // 2. 带 null 的整数列表（用于题2、题5）
        List<Integer> scores = Arrays.asList(88, null, 45, 92, 67, null, 30);

        // 3. 商品列表（用于题3，需要先建一个简单的 Product 类，见下方）
        List<Product> products = Arrays.asList(
                new Product("MacBook", 1200),
                new Product("Mouse", 50),
                new Product("Keyboard", 200),
                new Product("Monitor", 350)
        );

        Collections.sort(cities,(a,b)-> a.length() - b.length());
        System.out.println(cities);

    }


}
