package com.douma.practical.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie1 {

    private class Node {
        // 每个节点包含：
        // 1. 一个字符
        private Character c;
        // 2. 若干个子节点
        List<Node> children;
        // 标识，这个节点是否是一个单词最后一个字符
        boolean isWord;

        public Node(Character c) {
            this.c = c;
            this.children = new ArrayList<>();
            this.isWord = false;
        }
    }

    private Node root;

    public Trie1() {
        this.root = new Node('/');
    }

    public void add(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) {
            int index = containsChar(curr.children, c);
            if (index == -1) {
                curr.children.add(new Node(c));
                index = curr.children.size() - 1;
            }
            curr = curr.children.get(index);
        }

        curr.isWord = true;

    }

    private int containsChar(List<Node> children, Character c) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).c == c) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(String word) {
        Node curr = root;
        for (Character c : word.toCharArray()) {
            int index = containsChar(curr.children, c);
            if (index == -1) {
                return false;
            }
            curr = curr.children.get(index);
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

        System.out.println(trie.contains("biggere"));
    }
}
