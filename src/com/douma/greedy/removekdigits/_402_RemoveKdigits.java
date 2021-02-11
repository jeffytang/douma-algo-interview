package com.douma.greedy.removekdigits;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _402_RemoveKdigits {
    // O(k*n)
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            boolean hasDeleted = false;
            for (int j = 1; j < sb.length(); j++) {
                if (sb.charAt(j) < sb.charAt(j - 1)) {
                    sb.deleteCharAt(j - 1);
                    hasDeleted = true;
                    break;
                }
            }
            // 说明序列是递增的，那么删除最后一个字符
            if (!hasDeleted) sb.deleteCharAt(sb.length() - 1);
        }
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
        System.out.println(new _402_RemoveKdigits().removeKdigits("10200", 1));
    }
}
