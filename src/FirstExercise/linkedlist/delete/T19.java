package FirstExercise.linkedlist.delete;

import FirstExercise.linkedlist.ListNode;

/**
 *   19. 删除链表的倒数第 N 个结点
 */
@SuppressWarnings({"all"})
public class T19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode right = dummy;
        ListNode left = dummy;

        //先让 right 指针走 n 步
        while (n > 0) {
            right = right.next;
            n--;
        }

        //当right指针走到末尾时，left 和 right 恰好相差 n
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        if (left.next != null) {
            left.next = left.next.next;
        }
        return dummy.next;

    }

    /**
     * 两次遍历
     * public ListNode removeNthFromEnd(ListNode head, int n) {
     *
     *         ListNode dummy = new ListNode(-1, head);
     *         ListNode cur = dummy;
     *         int size = 0;
     *         while (cur.next != null) {
     *             size++;
     *             cur = cur.next;
     *         }
     *
     *         ListNode left = dummy;
     *         for (int i = 0; i < size - n; i++) {
     *             left = left.next;
     *         }
     *
     *         if (left.next != null) {
     *             left.next = left.next.next;
     *         }
     *         return dummy.next;
     *     }
     */

}
