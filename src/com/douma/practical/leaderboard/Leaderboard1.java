package com.douma.practical.leaderboard;

import java.util.*;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Leaderboard1 {
    private Map<Integer, Player> map;
    private TreeSet<Player> players;

    public Leaderboard1() {
        this.map = new HashMap<>();
        players = new TreeSet<>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getScores() == o2.getScores() ?
                        o1.getId() - o2.getId() :
                        o2.getScores() - o1.getScores();
            }
        });
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
        Player player = null;
        if (map.containsKey(playerId)) {
            player = map.get(playerId);
            // 需要先从 TreeSet 中删除
            // 等重新计算完 score 后再添加到 TreeSet 中
            // 因为这个 player 需要重新排序，而只有调用 TreeSet 的 add 方法，才能重新排序
            players.remove(player);
            player.setScores(player.getScores() + score);
        } else {
            player = new Player(playerId, score);
            map.put(playerId, player);
        }
        players.add(player);
    }

    /**
     * 返回前 k 名参赛者的得分总和
     * @param k
     * @return
     */
    public int top(int k) {
        Iterator<Player> it = players.iterator();
        int sum = 0;
        // O(k)
        while (it.hasNext() && k > 0) {
            sum += it.next().getScores();
            k--;
        }
        return sum;
    }

    /**
     * 将指定参赛者的成绩清零
     * @param playerId
     */
    public void reset(int playerId) { // O(logn)
        if (map.containsKey(playerId)) {
            players.remove(map.get(playerId));
            map.remove(playerId);
        }
    }

    public static void main(String[] args) {
        Leaderboard1 leaderboard = new Leaderboard1();
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
