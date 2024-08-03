package algo.linkedlist;

/*

There is a singly-linked list head and we want to delete a node node in it.
You are given the node to be deleted node. You will not be given access to the first node of head.
All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

 */
public class SingleListDeleteNode {

    public static void main(String[] args) {
        int[][] inputs = {
                {4,5,1,9},
                {4,5,1,9},
                {4,5,1,9}
        };
        int [] nodeValues = {5, 1, 4};
        for (int i = 0; i < inputs.length; i++) {
            SingleLinkedList list = new SingleLinkedList(inputs[i]);
            String listString = list.toString();
            SingleLinkedList.Node node = list.getNodeByValue(nodeValues[i]);
            deleteNode(node);
            String listStringAfterDelete = list.toString();
            System.out.println("Input: " + listString + " Delete Node: " + nodeValues[i] + " Result: " + listStringAfterDelete);
        }
    }

    public static void deleteNode(SingleLinkedList.Node node) {
        // copy value of next node to current node and delete next node
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
