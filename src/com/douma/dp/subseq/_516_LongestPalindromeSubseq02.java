package com.douma.dp.subseq;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _516_LongestPalindromeSubseq02 {
    private List<String> res = new ArrayList<>();
    private int len = Integer.MIN_VALUE;
    public int longestPalindromeSubseq(String s) {
        findSubSeq(s, 0, "");
        return len;
    }

    // start 参数用于剪枝
    private void findSubSeq(String s, int start, String subSeq) {
        if (start != 0) {
            res.add(subSeq);
            if (isPalindrome(subSeq)) {
                len = Math.max(len, subSeq.length());
            }
        }

        for (int i = start; i < s.length(); i++) {
            findSubSeq(s, i + 1, subSeq + s.charAt(i));
        }
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
        System.out.println(new _516_LongestPalindromeSubseq02()
                .longestPalindromeSubseq("bbbab"));
    }
}
