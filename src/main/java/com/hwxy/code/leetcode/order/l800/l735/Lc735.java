package com.hwxy.code.leetcode.order.l800.l735;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 735. 行星碰撞
 * https://leetcode.cn/problems/asteroid-collision/
 * 
 * @author hwxy
 * @date 2022/07/13
 **/
public class Lc735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return asteroids;
        }
        // 保存向右方向的行星
        Stack<Integer> rightStack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int asteroid : asteroids) {
            // 向右的入栈
            if (asteroid > 0) {
                rightStack.add(asteroid);
                continue;
            }
            // 没有向右的则向左的就是答案
            if (rightStack.isEmpty()) {
                ans.add(asteroid);
                continue;
            }
            // 存在像右的
            boolean sameSize = false;
            while (!rightStack.isEmpty()) {
                int rightAsteroid = rightStack.pop();
                int sum = rightAsteroid + asteroid;
                // 说明向左的更大
                if (sum < 0) {
                    continue;
                } else if (sum == 0) {
                    // 说明一样大
                    sameSize = true;
                    break;
                } else {
                    // 说明向右的大
                    rightStack.push(rightAsteroid);
                    break;
                }
            }
            if (!sameSize && rightStack.isEmpty()) {
                ans.add(asteroid);
            }
        }
        List<Integer> rightAns = new ArrayList<>(rightStack.size());
        while (!rightStack.isEmpty()) {
            rightAns.add(rightStack.pop());
        }
        for (int i = rightAns.size() - 1; i >= 0; i--) {
            ans.add(rightAns.get(i));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
