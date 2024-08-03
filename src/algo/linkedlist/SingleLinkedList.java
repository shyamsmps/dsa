package algo.linkedlist;

public class SingleLinkedList {

    Node head;

    public SingleLinkedList() {
        head = null;
    }

    public SingleLinkedList(int[] arr) {
        if (arr.length == 0) {
            head = null;
            return;
        }
        head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public String toString() {
        return getString(head);
    }

    public Node getNodeByValue(int val) {
        Node current = head;
        while (current != null) {
            if (current.val == val) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static String toString(Node head) {
        return getString(head);
    }

    private static String getString(Node head) {
        if (head == null) {
            return "Empty";
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.val).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
        }

        Node(int x, Node next) {
            val = x;
            this.next = next;
        }
    }

}
