package secondExercise.linkedlist;

import FirstExercise.linkedlist.ListNode;

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        if (left.next != null) {
            left.next = left.next.next;
        }
        return dummy.next;
    }
}
