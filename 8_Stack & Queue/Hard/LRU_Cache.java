// LRU Cache - https://leetcode.com/problems/lru-cache/description/

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

// Explanation
// LRUCache lRUCache = new LRUCache(2);
// lRUCache.put(1, 1); // cache is {1=1}
// lRUCache.put(2, 2); // cache is {1=1, 2=2}
// lRUCache.get(1);    // return 1
// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
// lRUCache.get(2);    // returns -1 (not found)
// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
// lRUCache.get(1);    // return -1 (not found)
// lRUCache.get(3);    // return 3
// lRUCache.get(4);    // return 4

import java.util.HashMap;

public class LRU_Cache {
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
    }

    public void remove(Node node) {
        map.remove(node.key);
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insertAfterHead(Node node) {
        map.put(node.key, node);
        Node nextNode = head.next;
        node.next = nextNode;
        nextNode.prev = node;
        head.next = node;
        node.prev = head;
    }
    // ----------------

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    // --------------------

    public static void main(String[] args) {
        // Initialize the LRUCache with capacity 2
        LRU_Cache lRUCache = new LRU_Cache(2);

        // Perform operations according to the example
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}

        System.out.println(lRUCache.get(1)); // return 1, cache is {2=2, 1=1}

        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}

        System.out.println(lRUCache.get(2)); // return -1 (not found)

        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}

        System.out.println(lRUCache.get(1)); // return -1 (not found)
        System.out.println(lRUCache.get(3)); // return 3, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(4)); // return 4, cache is {4=4, 3=3}
    }
}