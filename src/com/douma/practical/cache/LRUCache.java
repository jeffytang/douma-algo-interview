package com.douma.practical.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @官方网站 : https://douma.ke.qq.com
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class LRUCache<K, V> implements Cache<K, V> {
    private class Node {
        K key;
        V value;
        Node next;
        Node prev;
    }
    private Map<K, Node> cache;
    private int capacity;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;

        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public V get(K key) {
        Node node = cache.get(key);
        if (node == null) return null;
        // 将查询到的 node 移动到表头
        moveNodeToHead(node);
        return node.value;
    }

    private void moveNodeToHead(Node node) {
        // 1. 删除节点 node
        removeNode(node);

        // 2. 将节点 node 添加到表头
        addNodeToHead(node);
    }

    private void removeNode(Node node) {
        Node preNode = node.prev;
        Node nextNode = node.next;

        preNode.next = nextNode;
        nextNode.prev = preNode;

        node.prev = null;
        node.next = null;
    }

    // 将一个节点添加到头节点
    private void addNodeToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    @Override
    public void put(K key, V value) {
        Node node = cache.get(key);
        if (node == null) {
            // 1. 判断缓存容量大小
            if (cache.size() == capacity) {
                Node delNode = removeTailNode();
                cache.remove(delNode.key);
            }
            // 2. 创建节点
            node = new Node();
            node.key = key;
            node.value = value;

            // 3. 维护链表和缓存
            cache.put(key, node);
            addNodeToHead(node);
        } else {
            node.value = value;
            // 有的话，则将节点放到头结点
            moveNodeToHead(node);
        }
    }

    private Node removeTailNode() {
        Node delNode = tail.prev;
        removeNode(delNode);
        return delNode;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(3));
        cache.put(2, 5);
        cache.put(5, 6);
        System.out.println(cache.get(4));
    }
}
