package com.douma.dp.subseq;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _516_LongestPalindromeSubseq01 {
    private List<String> res = new ArrayList<>();

    public List<String> subSeqs(String s) {
        findSubSeq(s, 0, "");
        return res;
    }

    // start 参数用于剪枝
    private void findSubSeq(String s, int start, String subSeq) {
        if (start != 0) res.add(subSeq);

        for (int i = start; i < s.length(); i++) {
            findSubSeq(s, i + 1, subSeq + s.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new _516_LongestPalindromeSubseq01().subSeqs("bbbab"));
    }
}
