package com.douma.practical.leaderboard;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Player {
    private int id;
    private int scores;

    public Player(int id, int scores) {
        this.id = id;
        this.scores = scores;
    }

    public int getId() {
        return id;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }
}
