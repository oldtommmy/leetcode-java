package secondExercise.linkedlist;

import FirstExercise.linkedlist.ListNode;

public class T203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        //设计删除等操作，通常使用虚节点来简化统一一些操作
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
