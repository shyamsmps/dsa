package algo.problems.lru;

import java.util.HashMap;
import java.util.Map;

public class LruLinkedList {

    public static void main(String[] args) {
        int[][] input = LruInput.getInput1();
        LRUCache cache = new LRUCache(input[0][0]);
        for (int i=1; i<input.length; i++) {
            if (input[i].length == 1) {
                cache.get(input[i][0]);
            } else if (input[i].length == 2) {
                cache.put(input[i][0], input[i][1]);
            }
        }
    }

}

class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    ListStore list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new ListStore();
    }

    public int get(int key) {
        Node node = map.get(key);
        int value = -1;
        if (node != null) {
            list.update(node);
            value = node.value;
        }
        list.print();
        return value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                Node removed = list.remove();
                map.remove(removed.key);
            }
            map.put(key, list.add(key, value));
        } else {
            node.value = value;
            map.put(key, list.update(node));
        }
        list.print();

    }
}


class Node {
    public int key, value;
    public Node next, previous;
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class ListStore {
    public Node oldest;
    public Node newest;

    public Node add (int key, int value) {
        Node node = new Node(key, value);
        if (newest == null) {
            oldest = newest = node;
        } else {
            Node temp = newest;
            node.previous = temp;
            temp.next = node;
            newest = node;
        }
        return node;
    }

    public void print () {
        Node temp = oldest;
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node update (Node node) {
        if (node.next != null) {
            if (node.previous == null) {
                node.next.previous = null;
                oldest = node.next;
            } else {
                node.next.previous = node.previous;
                node.previous.next = node.next;
            }
            node.next = null;
            node.previous = null;
            return add(node.key, node.value);
        } else {
            return node;
        }
    }

    public Node remove () {
        Node removed = oldest;
        if (oldest.next != null) {
            oldest.next.previous = null;
        }
        oldest = oldest.next;
        return removed;
    }
}