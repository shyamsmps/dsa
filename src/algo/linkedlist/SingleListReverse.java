package algo.linkedlist;

/*

Given the head of a singly linked list, reverse the list, and return the reversed list.

Constraints:
The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 */

public class SingleListReverse {

    public static void main(String[] args) {
        int[][] inputs = {
                {1,2,3,4,5},
                {1,2},
                {1},
                {}
        };
        int [][] outputs = {
                {5,4,3,2,1},
                {2,1},
                {1},
                {}
        };
        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = new SingleLinkedList(inputs[i]);
            String input = list.toString();
            String expected = new SingleLinkedList(outputs[i]).toString();

            SingleLinkedList.Node node = reverseListBruteForce(list.getHead());
            String output = SingleLinkedList.toString(node);
            System.out.println("reverseListBruteForce. Input: " + input + " | Result: " + output + " | Expected: " + expected + " | Pass: " + output.equals(expected));

            node = reverseListBruteForce(list.getHead());
            output = SingleLinkedList.toString(node);
            System.out.println("reverseList. Input: " + input + " | Result: " + output + " | Expected: " + expected + " | Pass: " + output.equals(expected));

        }
    }

    public static SingleLinkedList.Node reverseListBruteForce(SingleLinkedList.Node head) {
        SingleLinkedList.Node newHead = null;
        SingleLinkedList.Node temp = head;
        while (temp != null) {
            newHead = new SingleLinkedList.Node(temp.val, newHead);
            temp = temp.next;
        }
        return newHead;
    }

    public SingleLinkedList.Node reverseList(SingleLinkedList.Node head) {

        // Keep track of the previous node and the current node
        // Reverse the current node's next pointer to point to the previous node
        // Move the previous node and the current node one step forward
        // Continue until the current node is null
        // Return the previous node as the new head

        SingleLinkedList.Node previous = null;
        SingleLinkedList.Node current = head;

        while (current != null) {
            SingleLinkedList.Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;

    }

}
