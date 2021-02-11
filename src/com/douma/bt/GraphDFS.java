package com.douma.bt;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class GraphDFS {
    public List<Integer> dfs(Graph g) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[g.getV()];
        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) {
                dfs(g, v, res, visited);
            }
        }
        return res;
    }

    private void dfs(Graph g, int v, List<Integer> res, boolean[] visited) {
        res.add(v);
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(g, w, res, visited);
            }
        }
    }
}
