package com.douma.dp.subarray;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _131_PalindromeSubstring00 {
    public List<List<String>> allPartitions(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int start,
                     List<String> path,
                     List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            // [start, i]
            String subStr = s.substring(start, i + 1);
            if (!isPalindrome(subStr)) continue;

            path.add(subStr);
            dfs(s, i + 1, path, res);
            path.remove(path.size() - 1);
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
        List<List<String>> res
                = new _131_PalindromeSubstring00().allPartitions("aab");
        for (List<String> path : res) {
            System.out.println(path);
        }
    }
}
