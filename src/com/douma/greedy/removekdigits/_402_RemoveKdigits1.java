package com.douma.greedy.removekdigits;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _402_RemoveKdigits1 {
    // 时间复杂度：O(k + n)
    // 空间复杂度：O(n)
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            sb.append(c);
        }
        sb = sb.reverse();

        // 删除前面是 0 的字符
        int len = sb.length();
        while (len != 0) {
            if (sb.charAt(0) > '0') break;
            sb.deleteCharAt(0);
            len = sb.length();
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new _402_RemoveKdigits1().removeKdigits("10200", 1));
    }
}
