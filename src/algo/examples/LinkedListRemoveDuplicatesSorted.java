package algo.examples;

import algo.data.structure.classes.ListNode;

import static algo.data.structure.classes.ListNode.createList;
import static algo.data.structure.classes.ListNode.print;

/**
 Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class LinkedListRemoveDuplicatesSorted {

    public static void main(String[] args) {
        print(deleteDuplicates(createList(new int[] {1,1,2,2,3})));
        print(deleteDuplicates(createList(new int[] {1,2})));
        print(deleteDuplicates(createList(new int[] {1,1,1})));
        print(deleteDuplicates(createList(new int[] {1})));
        print(deleteDuplicates(null));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode current = head;
            ListNode temp = head.next;
            while (temp != null) {
                if (current.val != temp.val) {
                    current.next = temp;
                    current = current.next;
                }
                temp = temp.next;
            }
            current.next = null;
        }
        return head;

    }

    public static ListNode deleteDuplicatesRecursive(ListNode head) {
        return head;
    }

}
