package com.douma.practical.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class _208_Trie {
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

    /** Initialize your data structure here. */
    public _208_Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
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

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
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

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (Character c : prefix.toCharArray()) { // O(n)
            // 1. 先从子节点中查找是否包含当前字符 c
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
