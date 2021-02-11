package com.douma.greedy;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _1578_MinCost {
    public int minCost(String s, int[] cost) {
        int res = 0;
        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            int maxCost = 0;
            int sumCost = 0;
            while (i < len && s.charAt(i) == c) {
                maxCost = Math.max(maxCost, cost[i]);
                sumCost = sumCost + cost[i];
                i++;
            }
            res += (sumCost - maxCost);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aaabaa";
        int[] cost = {1, 3, 2, 4, 1, 5};
        System.out.println(new _1578_MinCost().minCost(s, cost));
    }
}
