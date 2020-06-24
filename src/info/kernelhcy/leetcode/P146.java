package info.kernelhcy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P146
{
    public static void main(String[] args)
    {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

        cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    private static class LRUCache
    {

        public LRUCache(int capacity)
        {
            this.capacity = capacity;
            map = new HashMap<>();
            list = new DList();
        }

        public int get(int key)
        {
            ListNode n = map.get(key);
            if (n == null) return -1;

            list.remove(n);
            list.preppend(n);
            return n.val;
        }

        public void put(int key, int value)
        {
            ListNode n = map.get(key);
            if (n != null) {
                n.val = value;
                list.remove(n);
                list.preppend(n);
                return;
            }

            if (size < capacity) {
                ++size;
                n = new ListNode(key, value);
                list.preppend(n);
                map.put(key, n);
                return;
            }

            n = list.tail;
            list.remove(n);
            list.preppend(n);

            map.remove(n.key);
            n.key = key;
            n.val = value;
            map.put(key, n);
        }

        private static class DList
        {
            void remove(ListNode node)
            {
                if (node == null) return;
                if (node == head) {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    } else {
                        head.pre = null;
                    }
                    return;
                }

                if (node == tail) {
                    tail = tail.pre;
                    if (tail == null) {
                        head = null;
                    } else {
                        tail.next = null;
                    }
                    return;
                }

                node.pre.next = node.next;
                node.next.pre = node.pre;
                node.next = null;
                node.pre = null;
            }

            void preppend(ListNode node)
            {
                if (head == null) {
                    head = node;
                    tail = node;
                    return;
                }

                node.pre = null;
                node.next = head;
                head.pre = node;
                head = node;
            }

            void append(ListNode node)
            {
                if (head == null) {
                    head = node;
                    tail = node;
                    return;
                }

                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }

            private ListNode head, tail;
        }

        private final int capacity;
        private int size;

        private final DList list;

        private final Map<Integer, ListNode> map;
    }
}
