package algo.linkedlist;

/*

Learn:
Concept of dummy node to handle edge cases

Given the head of a linked list, remove the nth node from the end of the list and return its head.
Constraints:
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */

public class SingleListRemoveLastNthNode {

    public static void main(String[] args) {
        int[][] inputs = {
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1,2,3,4,5},
                {1},
                {1,2}
        };
        int[] n = {2, 5, 1, 1, 1};
        int [][] outputs = {
                {1,2,3,5},
                {2,3,4,5},
                {1,2,3,4},
                {},
                {1}
        };
        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = new SingleLinkedList(inputs[i]);
            String listString = list.toString();
            list.head = removeNthFromEndOptimized(list.getHead(), n[i]);
            String listStringAfterDelete = list.toString();
            SingleLinkedList expectedList = new SingleLinkedList(outputs[i]);
            String expectedListString = expectedList.toString();
            System.out.println("Input: " + listString + " | N: " + n[i] + " | Result: " + listStringAfterDelete + " | Expected: " + expectedListString + " | Pass: " + listStringAfterDelete.equals(expectedListString));
        }
    }

    public static SingleLinkedList.Node removeNthFromEnd(SingleLinkedList.Node head, int n) {
        // dummy to handle edge case where head needs to be deleted
        SingleLinkedList.Node dummy = new SingleLinkedList.Node(0, head);

        // previous to node to be deleted, to handle edge case where tail needs to be deleted
        SingleLinkedList.Node node = dummy;
        SingleLinkedList.Node temp = head;
        int currentSize = 0;
        // find the previous node to the node to be deleted
        while (temp != null) {
            if (currentSize-n >= 0) {
                node = node.next;
            }
            currentSize++;
            temp = temp.next;
        }

        // skip the node to be deleted
        node.next = node.next.next;
        return dummy.next;

    }

    public static SingleLinkedList.Node removeNthFromEndOptimized(SingleLinkedList.Node head, int n) {
        // Step 1: Create a dummy node and point its next to head
        SingleLinkedList.Node dummy = new SingleLinkedList.Node(0, head);
        SingleLinkedList.Node first = dummy;
        SingleLinkedList.Node second = dummy;

        // Step 2: Move first pointer n+1 steps forward
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 3: Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 4: Adjust the next pointer of the second node to remove the target node
        second.next = second.next.next;

        // Step 5: Return the new head, which is dummy.next
        return dummy.next;
    }
    
}
