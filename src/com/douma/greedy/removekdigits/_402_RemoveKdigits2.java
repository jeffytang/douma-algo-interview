package com.douma.greedy.removekdigits;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _402_RemoveKdigits2 {
    // 时间复杂度：O(k + n)
    // 空间复杂度：O(n)
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekFirst() > c) {
                deque.pollFirst();
                k--;
            }
            deque.addFirst(c);
        }
        for (int i = 0; i < k; i++) {
            deque.pollFirst();
        }

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        while (!deque.isEmpty()) {
            char c = deque.pollLast();
            if (c == '0' && isFirst) continue;
            sb.append(c);
            isFirst = false;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _402_RemoveKdigits2().removeKdigits("10200", 1));
    }
}
