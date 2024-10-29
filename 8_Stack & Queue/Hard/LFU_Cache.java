// LFU Cache - https://leetcode.com/problems/lfu-cache/description/

// Design and implement a data structure for a Least Frequently Used (LFU) cacheMap.

// Implement the LFUCache class:

// LFUCache(int capacity) Initializes the object with the capacity of the data structure.
// int get(int key) Gets the value of the key if the key exists in the cacheMap. Otherwise, returns -1.
// void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cacheMap reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
// To determine the least frequently used key, a use counter is maintained for each key in the cacheMap. The key with the smallest use counter is the least frequently used key.

// When a key is first inserted into the cacheMap, its use counter is set to 1 (due to the put operation). The use counter for a key in the cacheMap is incremented either a get or put operation is called on it.

// The functions get and put must each run in O(1) average time complexity.

// Example 1:

// Input
// ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, 3, null, -1, 3, 4]

// Explanation
// // cnt(x) = the use counter for key x
// // cacheMap=[] will show the last used order for tiebreakers (leftmost element is  most recent)
// LFUCache lfu = new LFUCache(2);
// lfu.put(1, 1);   // cacheMap=[1,_], cnt(1)=1
// lfu.put(2, 2);   // cacheMap=[2,1], cnt(2)=1, cnt(1)=1
// lfu.get(1);      // return 1
//                  // cacheMap=[1,2], cnt(2)=1, cnt(1)=2
// lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
//                  // cacheMap=[3,1], cnt(3)=1, cnt(1)=2
// lfu.get(2);      // return -1 (not found)
// lfu.get(3);      // return 3
//                  // cacheMap=[3,1], cnt(3)=2, cnt(1)=2
// lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
//                  // cacheMap=[4,3], cnt(4)=1, cnt(3)=2
// lfu.get(1);      // return -1 (not found)
// lfu.get(3);      // return 3
//                  // cacheMap=[3,4], cnt(4)=1, cnt(3)=3
// lfu.get(4);      // return 4
//                  // cacheMap=[4,3], cnt(4)=2, cnt(3)=3

import java.util.HashMap;

public class LFU_Cache {
    int capacity;
    int curSize;
    int minFrequency;
    HashMap<Integer, Node> cacheMap;
    HashMap<Integer, DoublyLinkedList> freqMap;

    LFU_Cache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.freqMap = new HashMap<>();
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node = cacheMap.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            updateNode(node);
        } else {
            curSize++;
            if (curSize > capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFrequency);
                Node nodeToRemove = minFreqList.tail.prev;
                cacheMap.remove(nodeToRemove.key);
                minFreqList.removeNode(nodeToRemove);
                curSize--;
            }
            minFrequency = 1;
            Node newNode = new Node(key, value);
            DoublyLinkedList curList = freqMap.getOrDefault(minFrequency, new DoublyLinkedList());
            curList.insertNodeAfterHead(newNode);
            freqMap.put(minFrequency, curList);
            cacheMap.put(key, newNode);
        }
    }

    public void updateNode(Node node) {
        int curFreq = node.frequency;
        DoublyLinkedList curList = freqMap.get(curFreq);
        curList.removeNode(node);
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }
        node.frequency++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.frequency, new DoublyLinkedList());
        newList.insertNodeAfterHead(node);
        freqMap.put(node.frequency, newList);
    }
    // --------------------

    class DoublyLinkedList {
        Node head;
        Node tail;
        int listSize;

        DoublyLinkedList() {
            this.listSize = 0;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }

        public void insertNodeAfterHead(Node node) {
            Node nextNode = head.next;
            node.next = nextNode;
            node.prev = head;
            head.next = node;
            nextNode.prev = node;
            listSize++;
        }
    }

    class Node {
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
            this.next = null;
            this.prev = null;
        }
    }
    // ---------------
    
    public static void main(String[] args) {
        LFU_Cache lfu = new LFU_Cache(2);

        lfu.put(1, 1); // cacheMap=[1,_], cnt(1)=1
        lfu.put(2, 2); // cacheMap=[2,1], cnt(2)=1, cnt(1)=1

        System.out.println(lfu.get(1)); // return 1, cacheMap=[1,2], cnt(2)=1, cnt(1)=2

        lfu.put(3, 3); // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        System.out.println(lfu.get(2)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3, cacheMap=[3,1], cnt(3)=1, cnt(1)=2

        lfu.put(4, 4); // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        System.out.println(lfu.get(1)); // return -1 (not found)
        System.out.println(lfu.get(3)); // return 3, cacheMap=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4)); // return 4, cacheMap=[4,3], cnt(4)=2, cnt(3)=3
    }
}