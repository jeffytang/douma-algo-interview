package com.douma.greedy.coinchange;

import java.util.Arrays;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _322_CoinChange1 {
    // 贪心
    public int coinChange(int[] c, int k) {
        Arrays.sort(c);

        int rest = k;
        int res = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            int currCount = rest / c[i]; // 需要当前面值多少个
            rest = rest - currCount * c[i]; // 还剩多少

            res += currCount;
            if (rest == 0) {
                return res;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] c = {3, 5};
        System.out.println(new _322_CoinChange1().coinChange(c, 11));
    }
}
