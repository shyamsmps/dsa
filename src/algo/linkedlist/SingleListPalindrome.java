package algo.linkedlist;

/*

Learn:
Concept of slow and fast pointers to find the middle of a linked list or to find 1/3 or 1/4 of the list

Question:
Given the head of a singly linked list, determine if it is a palindrome.
Referenced from https://leetcode.com/problems/palindrome-linked-list/
Constraints:
The number of nodes in the list is in the range [1, 10^5].
0 <= Node.val <= 9
 */

public class SingleListPalindrome {

    public static void main(String[] args) {
        int[][] inputs = {
                {1,2,3,4,5,6,7},
                {1,2,3,4,5,6,7,8},
                {1,2,3,4,3,2,1},
                {1,2,3,3,2,1},
                {1,2,3,2,1},
                {1,2,2,1},
                {1,2,1},
                {1},
                {}
        };
        boolean[] outputs = {
                false,
                false,
                true,
                true,
                true,
                true,
                true,
                true,
                true
        };
        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = new SingleLinkedList(inputs[i]);
            String input = list.toString();
            boolean expected = outputs[i];

            boolean output = isPalindrome(list.getHead());
            System.out.println("isPalindrome. Input: " + input + " | Result: " + output + " | Expected: " + expected + " | Pass: " + (output == expected));
        }
    }

    public static boolean isPalindrome(SingleLinkedList.Node head) {
        SingleLinkedList.Node head1 = null; // first half reversed
        SingleLinkedList.Node current = head; // current position in the traversal
        SingleLinkedList.Node head2 = head; // second half, original
        int size = 0; // keep track of the number of nodes

        // Traverse the list and reverse the first half
        while (current != null) {
            current = current.next;
            size++;
            if (size % 2 == 0) { // every alternate time, move one element to first list
                SingleLinkedList.Node temp = head2;
                head2 = head2.next;
                temp.next = head1;
                head1 = temp;
            }
        }

        // If the list size is odd, skip the middle element in the first half
        if (size % 2 != 0) {
            head2 = head2.next;
        }

        // Compare the first half (reversed) and the second half
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }

    public boolean isPalindromeStandard(SingleLinkedList.Node head) {
        if (head == null || head.next == null) {
            return true; // A list with 0 or 1 nodes is a palindrome
        }

        // Step 1: Find the middle of the linked list using slow and fast pointers
        SingleLinkedList.Node slow = head;
        SingleLinkedList.Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        SingleLinkedList.Node secondHalf = reverseList(slow);

        // Step 3: Compare the first half and the reversed second half
        SingleLinkedList.Node firstHalf = head;
        SingleLinkedList.Node secondHalfCopy = secondHalf; // To restore the list later
        boolean result = true;
        while (result && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                result = false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Step 4: Restore the list to its original state (optional)
        reverseList(secondHalfCopy);

        return result;
    }

    // Helper method to reverse a linked list
    private SingleLinkedList.Node reverseList(SingleLinkedList.Node head) {
        SingleLinkedList.Node prev = null;
        SingleLinkedList.Node current = head;
        while (current != null) {
            SingleLinkedList.Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void print(
            SingleLinkedList.Node head1,
            SingleLinkedList.Node head2,
            SingleLinkedList.Node current,
            int size) {
        System.out.println("size: " + size);
        System.out.println("head1: " + SingleLinkedList.toString(head1));
        System.out.println("head2: " + SingleLinkedList.toString(head2));
        System.out.println();
    }

}
