package com.douma.bt.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _93_RestoreIpAddresses {
    private List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s == null || s.isEmpty())
            return res;
        restoreIp(s, 0, "", 0);
        return res;
    }

    private void restoreIp(String s, int index, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            res.add(restored);
            return;
        }
        for (int segmentLen = 1; segmentLen < 4; segmentLen++) {
            if (index + segmentLen > s.length()) break;
            String segment = s.substring(index, index + segmentLen);
            if (!isValidIpSegment(segment)) continue;
            String suffix = count == 3 ? "" : ".";
            restoreIp(s, index + segmentLen, restored + segment+ suffix, count + 1);
        }
    }

    private boolean isValidIpSegment(String segment) {
        // 长度不能大于 3
        int len = segment.length();
        if (len > 3) return false;

        // 1. ip 段如果是以 0 开始的话，那么这个 ip 段只能是 0
        // 2. ip 段需要小于等于 255
        return (segment.charAt(0) == '0') ?
                (len == 1) : (Integer.valueOf(segment) <= 255);
    }

    public static void main(String[] args) {
        System.out.println(new _93_RestoreIpAddresses().restoreIpAddresses("101023"));
    }
}
