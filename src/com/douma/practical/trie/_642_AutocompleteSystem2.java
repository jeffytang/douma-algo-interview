package com.douma.practical.trie;

import java.util.*;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _642_AutocompleteSystem2 {
    private class SentenceInfo {
        String content;
        int time;

        SentenceInfo(String content, int time) {
            this.content = content;
            this.time = time;
        }
    }

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        // times == 0 说明，这个节点不是字符串的结尾节点
        // times > 0 说明是结尾字符节点
        int times = 0;
    }

    private TrieNode root;
    // 记录用户当前的输入
    private String currSentence = "";

    public _642_AutocompleteSystem2(String[] sentences, int[] times) {
        root = new TrieNode();
        // 构建前缀树
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    public void insert(String s, int times) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.times += times;
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') { // 用户输入完成一个句子
            // 更新这个句子总的被搜索次数
            insert(currSentence, 1);
            // 清除用户当前输入
            currSentence = "";
        } else {
            // 1. 将当前输入字符拼接到当前句子
            currSentence += c;

            // 2. 找到所有以当前输入字符串开头的句子
            // 从字典树中找到包含 currSentence 为前缀的所有句子
            List<SentenceInfo> list = lookup(currSentence);

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

    // 从当前前缀树中搜索以 s 开头的所有的句子
    public List<SentenceInfo> lookup(String s) {
        List<SentenceInfo> list = new ArrayList<>();

        // 1. 找到前缀
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return list;
            }
            curr = curr.children.get(c);
        }

        // 2. 找到以前缀结尾的所有的字符串
        dfs(curr, s, list);

        return list;
    }

    private void dfs(TrieNode curr, String s, List<SentenceInfo> list) {
        if (curr.times > 0) {
            list.add(new SentenceInfo(s, curr.times));
        }

        for (char c : curr.children.keySet()) {
            dfs(curr.children.get(c), s + c, list);
        }
    }
}
