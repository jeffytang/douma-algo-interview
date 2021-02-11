package com.douma.dp.subarray;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _647_PalindromeSubstring00 {
    // 暴力
    // 时间复杂度：O(n^3)
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        // 穷举所有的子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // [i, j]
                String subStr = s.substring(i, j + 1);
                if (isPalindrome(subStr)) res++;
            }
        }
        return res;
    }

    // 判断子串是否是回文
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _647_PalindromeSubstring00().countSubstrings("aaa"));
    }
}
