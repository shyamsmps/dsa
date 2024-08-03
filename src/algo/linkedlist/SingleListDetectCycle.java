package algo.linkedlist;

/*
Learn:
Use slow and fast pointers approach

Problem:
Detect cycle in single linked list

 */

public class SingleListDetectCycle {

    public static void main(String[] args) {
        SingleLinkedList.Node head = new SingleLinkedList.Node(1);
        SingleLinkedList.Node node2 = new SingleLinkedList.Node(2);
        SingleLinkedList.Node node3 = new SingleLinkedList.Node(3);
        SingleLinkedList.Node node4 = new SingleLinkedList.Node(4);
        SingleLinkedList.Node node5 = new SingleLinkedList.Node(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        // No cycle
        System.out.println(hasCycle(head)); // false
        // Create a cycle
        node5.next = node2;
        System.out.println(hasCycle(head)); // true
    }

    public static boolean hasCycle(SingleLinkedList.Node head) {
        // A list with 0 or 1 nodes can't have a cycle
        if (head == null || head.next == null) {
            return false;
        }
        // Floyd’s Cycle-Finding Algorithm, also known as the "Tortoise and Hare" algorithm
        // The idea is to have two pointers, one moving at twice the speed of the other
        // If there is a cycle, the two pointers will meet at some point
        SingleLinkedList.Node slow = head;
        SingleLinkedList.Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    

}
