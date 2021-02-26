package com.douma.practical.trie;

import java.util.*;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _642_AutocompleteSystem1 {
    private class SentenceInfo {
        String content;
        int time;

        SentenceInfo(String content, int time) {
            this.content = content;
            this.time = time;
        }
    }

    // 记录每个句子被搜索的次数
    private Map<String, Integer> map;
    // 记录用户当前的输入
    private String currSentence = "";

    public _642_AutocompleteSystem1(String[] sentences, int[] times) {
        map = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') { // 用户输入完成一个句子
            // 更新这个句子总的被搜索次数
            map.put(currSentence, map.getOrDefault(currSentence, 0) + 1);
            // 清除用户当前输入
            currSentence = "";
        } else {
            // 1. 将当前输入字符拼接到当前句子
            currSentence += c;

            // 2. 找到所有以当前输入字符串开头的句子
            List<SentenceInfo> list = new ArrayList<>();
            // 线性查找
            for (String sentence : map.keySet()) { // O(n*k)
                if (sentence.startsWith(currSentence)) {
                    list.add(new SentenceInfo(sentence, map.get(sentence)));
                }
            }

            // 3. 拿到被搜索次数排名前 3 的句子
            Collections.sort(list, new Comparator<SentenceInfo>() {
                @Override
                public int compare(SentenceInfo o1, SentenceInfo o2) {
                    return o1.time == o2.time ?
                            o1.content.compareTo(o2.content) :
                            o2.time - o1.time;
                }
            });
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                res.add(list.get(i).content);
            }
        }
        return res;
    }
}
