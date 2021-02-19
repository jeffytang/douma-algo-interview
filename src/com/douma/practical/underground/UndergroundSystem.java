package com.douma.practical.underground;

import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class UndergroundSystem {
    // 维护每个乘客的起始站信息
    private Map<Integer, Start> startInfo;
    // 维护两个站的乘客信息：所有的乘客数，以及所有乘客花的时间
    private Map<StartEnd, SumAmount> table;

    // 编号为 id 的乘客在 t 时刻进入地铁站 stationName
    public void checkIn(int id, String stationName, int t) {
        startInfo.put(id, new Start(stationName, t));
    }

    // 编号为 id 的乘客在 t 时刻离开地铁站 stationName
    public void checkOut(int id, String stationName, int t) {
        // 拿到起始点信息
        Start start = startInfo.get(id);

        // 计算花费的时间
        StartEnd key = new StartEnd(start.getStation(), stationName);
        SumAmount sumAmount = table.getOrDefault(key, new SumAmount(0, 0));
        sumAmount.setAmount(sumAmount.getAmount() + 1);
        sumAmount.setSum(sumAmount.getSum() + (t - start.getTime()));

        table.put(key, sumAmount);
    }

    // 返回地铁站 startStation 到地铁站 endStation 的平均花费时间
    public double getAverageTime(String startStation, String endStation) {
        StartEnd key = new StartEnd(startStation, endStation);
        SumAmount sumAmount = table.get(key);
        int sum = sumAmount.getSum();
        int amount = sumAmount.getAmount();
        return 1.0 * sum / amount;
    }
}
