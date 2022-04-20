package algo.data.structure.classes;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createList(int[] arr) {
        ListNode ls = null;
        if (arr.length > 0) {
            ListNode p = new ListNode(arr[0]);
            ls = p;
            for (int i=1; i<arr.length; i++) {
                p.next = new ListNode(arr[i]);
                p = p.next;
            }
        }
        return ls;
    }

    public static void print(ListNode ls) {
        while (ls!= null) {
            System.out.print(ls.val + ", ");
            ls = ls.next;
        }
        System.out.println();
    }
}
