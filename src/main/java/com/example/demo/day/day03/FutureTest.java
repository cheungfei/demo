package com.example.demo.day.day03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-01-28 14:01
 */
public class FutureTest {
    public static void main(String[] args) {

    }

    private static List<String> findPriceSync(String product) {
        return shopList.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    private static List<Shop> shopList = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll")
    );
}
