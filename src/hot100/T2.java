package hot100;

import FirstExercise.linkedlist.ListNode;

public class T2{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;
        int value = 0;
        ListNode cur = new ListNode(0);
        ListNode dummy = new ListNode();
        dummy.next = cur;
        while (node1 != null || node2 != null) {
            int n1 = node1 == null ? 0 : node1.val;
            int n2 = node2 == null ? 0 : node2.val;
            value = n1 + n2;
            if (carry == 1) {
                value++;
            }
            carry = value / 10;
            value = value % 10;
            cur.next = new ListNode(value);
            cur = cur.next;
            if (node1 == null) {
                node2 = node2.next;
            } else if (node2 == null) {
                node1 = node1.next;
            } else {
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}