package com.douma.practical.leaderboard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Leaderboard {
    private Map<Integer, Integer> map;

    public Leaderboard() {
        this.map = new HashMap<>();
    }

    /**
     * 记录每个参赛者的分数
     * 逻辑：
     *      1. 假如参赛者已经在排行榜中，就给他的当前得分增加 score 分值并更新排行
     *      2. 假如参赛者不在排行榜中，就把他添加到排行榜，并将分数设置为 score
     * @param playerId  参赛者 Id，唯一标识一个参赛者
     * @param score 本次参赛者得分
     */
    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            map.put(playerId, map.get(playerId) + score);
        } else {
            map.put(playerId, score);
        }
    }

    /**
     * 返回前 k 名参赛者的得分总和
     * @param k
     * @return
     */
    public int top(int k) {
        // 1. 按照分数升序排序
        Integer[] scores = map.values().toArray(new Integer[map.values().size()]);
        // O(nlogn) - 性能瓶颈
        Arrays.sort(scores, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 2. 拿到前 k 名的分数，累加
        // O(k)
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += scores[i];
        }

        return sum;
    }

    /**
     * 将指定参赛者的成绩清零
     * @param playerId
     */
    public void reset(int playerId) {
        if (map.containsKey(playerId)) {
            map.remove(playerId);
        }
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1, 20);
        leaderboard.addScore(2, 30);
        leaderboard.addScore(3, 16);
        leaderboard.addScore(4, 44);

        System.out.println(leaderboard.top(2));

        leaderboard.addScore(2, 34);
        leaderboard.addScore(3, 23);

        System.out.println(leaderboard.top(1));

        leaderboard.reset(2);
        leaderboard.reset(4);

        System.out.println(leaderboard.top(1));
    }
}
