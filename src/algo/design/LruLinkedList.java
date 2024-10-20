package algo.design;

import java.util.HashMap;
import java.util.Map;

public class LruLinkedList {

    public static int[][] getInput1() {
        return new int[][]{{10},
                {10,13},
                {3,17},
                {6,11},
                {10,5},
                {9,10},
                {13},
                {2,19},
                {2},
                {3},
                {5,25},
                {8},
                {9,22},
                {5,5},
                {1,30},
                {11},
                {9,12},
                {7},
                {5},
                {8},
                {9},
                {4,30},
                {9,3},
                {9},
                {10},
                {10},
                {6,14},
                {3,1},
                {3},
                {10,11},
                {8},
                {2,14},
                {1},
                {5},
                {4},
                {11,4},
                {12,24},
                {5,18},
                {13},
                {7,23},
                {8},
                {12},
                {3,27},
                {2,12},
                {5},
                {2,9},
                {13,4},
                {8,18},
                {1,7},
                {6},
                {9,29},
                {8,21},
                {5},
                {6,30},
                {1,12},
                {10},
                {4,15},
                {7,22},
                {11,26},
                {8,17},
                {9,29},
                {5},
                {3,4},
                {11,30},
                {12},
                {4,29},
                {3},
                {9},
                {6},
                {3,4},
                {1},
                {10},
                {3,29},
                {10,28},
                {1,20},
                {11,13},
                {3},
                {3,12},
                {3,8},
                {10,9},
                {3,26},
                {8},
                {7},
                {5},
                {13,17},
                {2,27},
                {11,15},
                {12},
                {9,19},
                {2,15},
                {3,16},
                {1},
                {12,17},
                {9,1},
                {6,19},
                {4},
                {5},
                {5},
                {8,1},
                {11,7},
                {5,2},
                {9,28},
                {1},
                {2,2},
                {7,4},
                {4,22},
                {7,24},
                {9,26},
                {13,28},
                {11,26}};
    }

    public static void main(String[] args) {
        int[][] input = getInput1();
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