package algo.linkedlist;

/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged list.
Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
Refer: https://leetcode.com/problems/merge-two-sorted-lists/
 */

public class SingleListMergeSortedLists {

    public static void main(String[] args) {
        int[][] inputOutputs = {
                {1, 2, 4}, {1, 3, 4}, {1, 1, 2, 3, 4, 4},
                {}, {0}, {0},
                {}, {}, {},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 1, 2, 2, 3, 3, 4, 4, 5, 5},
                {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {35}, {1}, {1, 35}
        };
        for (int i = 0; i < inputOutputs.length; i += 3) {
            SingleLinkedList list1 = new SingleLinkedList(inputOutputs[i]);
            SingleLinkedList list2 = new SingleLinkedList(inputOutputs[i + 1]);
            String input1 = list1.toString();
            String input2 = list2.toString();
            String expected = new SingleLinkedList(inputOutputs[i + 2]).toString();

            SingleLinkedList.Node node = mergeTwoLists(list1.getHead(), list2.getHead());
            String output = SingleLinkedList.toString(node);
            System.out.println("mergeTwoLists. Input1: " + input1 + " | Input2: " + input2 + " | Result: " + output + " | Expected: " + expected + " | Pass: " + output.equals(expected));

            list1 = new SingleLinkedList(inputOutputs[i]);
            list2 = new SingleLinkedList(inputOutputs[i + 1]);
            node = mergeTwoListsOptimized(list1.getHead(), list2.getHead());
            output = SingleLinkedList.toString(node);
            System.out.println("mergeTwoListsOptimized. Input1: " + input1 + " | Input2: " + input2 + " | Result: " + output + " | Expected: " + expected + " | Pass: " + output.equals(expected));
        }
    }


    public static SingleLinkedList.Node mergeTwoLists(SingleLinkedList.Node list1, SingleLinkedList.Node list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // p1 is the current node of merged list. We always maintain p1 to be the smaller node.
        // p2 is the current node of the list to be merged. We always maintain p2 to be the larger node and head of the remaining other de-linked list.
        SingleLinkedList.Node p1 = list1;
         SingleLinkedList.Node p2 = list2;
         if (list2.val < list1.val) {
             p1 = list2;
             p2 = list1;
         }
         SingleLinkedList.Node head = p1;

         while (p1.next != null) {
             if (p2.val < p1.next.val) {
                 SingleLinkedList.Node temp = p1.next;
                 p1.next = p2;
                 p2 = temp;
             }
             p1 = p1.next;
         }

         // if remaining
        p1.next = p2;

        return head;
        
    }

    public static SingleLinkedList.Node mergeTwoListsOptimized(SingleLinkedList.Node list1, SingleLinkedList.Node list2) {
        SingleLinkedList.Node dummy = new SingleLinkedList.Node(-1);
        SingleLinkedList.Node current = dummy;

        while (list1 != null && list2 != null) {
            if (list2.val < list1.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;

    }
}
