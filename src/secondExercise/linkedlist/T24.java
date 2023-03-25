package secondExercise.linkedlist;

import FirstExercise.linkedlist.ListNode;

public class T24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode left = head;
        ListNode right;
        while (left != null) {
            right = left.next;
            if (right == null) {
                break;
            }
            left.next = right.next;
            right.next = left;
            pre.next = right;
            pre = left;
            left = left.next;
            if (left == null) {
                break;
            }
        }
        return dummy.next;
    }
}
