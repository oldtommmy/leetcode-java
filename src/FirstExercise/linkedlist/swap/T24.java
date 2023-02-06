package FirstExercise.linkedlist.swap;

import FirstExercise.linkedlist.ListNode;


@SuppressWarnings({"all"})
public class T24 {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = tmp1;
            tmp1.next = tmp2;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new T24().swapPairs(new ListNode().createLinkedList(new int[]{1,2,3,4,5})));
    }
}
