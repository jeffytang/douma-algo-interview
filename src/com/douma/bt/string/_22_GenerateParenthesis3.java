package com.douma.bt.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _22_GenerateParenthesis3 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        dfs(n, "", res, 0, 0);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        if (open < n) {
            dfs(n, path + "(", res, open + 1, close);
        }
        if (close < open) {
            dfs(n, path + ")", res, open, close + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _22_GenerateParenthesis3().generateParenthesis(3));
    }
}
