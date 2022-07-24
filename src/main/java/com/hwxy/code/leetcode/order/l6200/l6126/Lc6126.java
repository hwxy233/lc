package com.hwxy.code.leetcode.order.l6200.l6126;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

import com.hwxy.code.utils.JsonUtil;

/**
 * 6126. 设计食物评分系统
 * https://leetcode.cn/contest/weekly-contest-303/problems/design-a-food-rating-system/
 * 
 * @author hwxy
 * @date 2022/07/24
 **/
public class Lc6126 {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                JsonUtil.convertToT(
                        "[\"emgqdbo\",\"jmvfxjohq\",\"qnvseohnoe\",\"yhptazyko\",\"ocqmvmwjq\"]",
                        String[].class),
                JsonUtil.convertToT(
                        "[\"snaxol\",\"snaxol\",\"snaxol\",\"fajbervsj\",\"fajbervsj\"]",
                        String[].class),
                JsonUtil.convertToIntArray("[2,6,18,6,5]"));
        foodRatings.changeRating("qnvseohnoe", 11);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        foodRatings.changeRating("emgqdbo", 3);
        foodRatings.changeRating("jmvfxjohq", 9);
        foodRatings.changeRating("emgqdbo", 14);
        System.out.println(foodRatings.highestRated("fajbervsj"));
        System.out.println(foodRatings.highestRated("snaxol"));
    }
}


class FoodRatings {

    private final Map<String, TreeSet<Pair>> rank;

    private final Map<String, String> foodCuisine;

    private final Map<String, Pair> foodPair;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        rank = new HashMap<>(cuisines.length);
        foodCuisine = new HashMap<>(foods.length);
        foodPair = new HashMap<>(foods.length);

        for (int i = 0; i < foods.length; i++) {
            String cuisine = cuisines[i];
            String food = foods[i];
            int rating = ratings[i];
            Pair pair = new Pair(food, rating);
            rank.computeIfAbsent(cuisine, key -> new TreeSet<>((o1, o2) -> {
                if (o1.rating == o2.rating) {
                    return o1.food.compareTo(o2.food);
                }
                return Integer.compare(o2.rating, o1.rating);
            })).add(pair);
            foodCuisine.put(food, cuisine);
            foodPair.put(food, pair);
        }
    }

    public void changeRating(String food, int newRating) {
        Pair pair = new Pair(food, newRating);
        rank.get(foodCuisine.get(food)).remove(foodPair.get(food));
        rank.get(foodCuisine.get(food)).add(pair);
        foodPair.put(food, pair);
    }

    public String highestRated(String cuisine) {
        return rank.get(cuisine).iterator().next().food;
    }

    static class Pair {
        String food;
        int rating;

        public Pair(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(food, pair.food);
        }

        @Override
        public int hashCode() {
            return food.hashCode();
        }
    }
}
