package com.douma.practical.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
/**
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 */
public class _208_Trie1 {
    private class Node {
        // 每个节点包含：
        // 1. 一个字符
        // 2. 若干个子节点
        // a-z 26 个字符
        // a -> 0, b -> 1.... z -> 26
        // a - a = 0
        // b - a = 1
        Node[] children;
        // 标识，这个节点是否是一个单词最后一个字符
        boolean isWord;

        Node() {
            children = new Node[26];
            isWord = false;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public _208_Trie1() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) { // O(n)
            // 1. 先从子节点中查找是否包含当前字符 c
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) { // O(n)
            // 1. 先从子节点中查找是否包含当前字符 c
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (Character c : prefix.toCharArray()) { // O(n)
            // 1. 先从子节点中查找是否包含当前字符 c
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}
