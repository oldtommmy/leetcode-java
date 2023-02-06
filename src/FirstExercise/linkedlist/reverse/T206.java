package FirstExercise.linkedlist.reverse;

import FirstExercise.linkedlist.ListNode;

/**
 *   206 反转链表
 */
@SuppressWarnings({"all"})
public class T206 {
    public ListNode reverseList(ListNode head) {

        //递归法
        //return reverse(null, head);
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归
    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }

        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;
        // 更新pre、cur位置
        // pre = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
}
