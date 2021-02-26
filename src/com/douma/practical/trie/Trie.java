package com.douma.practical.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class Trie {
    private class Node {
        // 每个节点包含：
        // 1. 一个字符
        // 2. 若干个子节点
        Map<Character, Node> children;
        // 标识，这个节点是否是一个单词最后一个字符
        boolean isWord;

        Node() {
            children = new HashMap<>();
            isWord = false;
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    // 添加单词
    // O(n)
    public void add(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) { // O(n)
            // 1. 先从子节点中查找是否包含当前字符 c
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    // 判断是否包含指定的单词
    // O(n)
    public boolean contains(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) { // O(n)
            // 1. 先从子节点中查找是否包含当前字符 c
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("big");
        trie.add("pat");
        trie.add("bigger");
        trie.add("dog");
        trie.add("door");

        System.out.println(trie.contains("dogddd"));
    }

}
