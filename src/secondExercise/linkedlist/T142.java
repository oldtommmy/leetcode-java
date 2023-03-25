package secondExercise.linkedlist;

import FirstExercise.linkedlist.ListNode;

public class T142 {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode n1 = fast;
                ListNode n2 = head;
                while (n1 != n2) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return n1;
            }
        }
        return null;
    }
}
