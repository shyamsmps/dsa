package algo.linkedlist;

import algo.data.structure.classes.ListNode;

import static algo.data.structure.classes.ListNode.createList;
import static algo.data.structure.classes.ListNode.print;

/**
    You are given the heads of two sorted linked lists list1 and list2.
    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
    Return the head of the merged linked list.
 */
public class LinkedListMergeSortedLists {

    public static void main(String[] args) {
        print(mergeTwoListsTough(createList(new int[] {1,2,3}), createList(new int[] {1,2,3})));
        print(mergeTwoListsEasy(createList(new int[] {1,2,3}), createList(new int[] {1,2,3})));

        print(mergeTwoListsTough(createList(new int[] {5}), createList(new int[] {1,2,3})));
        print(mergeTwoListsEasy(createList(new int[] {5}), createList(new int[] {1,2,3})));

        print(mergeTwoListsTough(createList(new int[] {1,2,3}), createList(new int[] {})));
        print(mergeTwoListsEasy(createList(new int[] {1,2,3}), createList(new int[] {})));

        print(mergeTwoListsTough(createList(new int[] {2,10,10,15,1001}), createList(new int[] {1,1,3,6,11,15,1002})));
        print(mergeTwoListsEasy(createList(new int[] {2,10,10,15,1001}), createList(new int[] {1,1,3,6,11,15,1002})));
    }

    public static ListNode mergeTwoListsTough(ListNode list1, ListNode list2) {
        System.out.print("list1: ");
        print(list1);
        System.out.print("list2: ");
        print(list2);
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list2.val > list1.val) {
            list1.next = mergeTwoListsTough(list1.next, list2);
            return list1; // all items will be merged in list1 and list1 will be returned eventually
        } else {
            list2.next = mergeTwoListsTough(list1, list2.next);
            return list2; // all items will be merged in list2 and list2 will be returned eventually
        }
    }

    public static ListNode mergeTwoListsEasy(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode p1; // small
        ListNode p2; // large
        ListNode m; // merged

        if (list2.val < list1.val) {
            p1 = list2;
            m = list2;
            p2 = list1;
        } else {
            p1 = list1;
            m = list1;
            p2 = list2;
        }

        merge(p1, p2);
        return m;
    }

    private static void merge(ListNode list1, ListNode list2) {
        if (list1.next == null) {
            list1.next = list2;
            return;
        }
        if (list2 == null) {
            return;
        }
        if (list1.next.val > list2.val) {
            list1.next = new ListNode(list2.val, list1.next);
            list2 = list2.next;
        }
        list1 = list1.next;
        merge(list1, list2);
    }


}
