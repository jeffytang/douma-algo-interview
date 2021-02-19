package com.douma.practical.underground;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Start {
    private String station;
    private int time;

    public Start(String station, int time) {
        this.station = station;
        this.time = time;
    }

    public String getStation() {
        return station;
    }

    public int getTime() {
        return time;
    }
}
