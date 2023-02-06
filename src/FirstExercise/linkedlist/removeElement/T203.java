package FirstExercise.linkedlist.removeElement;

import FirstExercise.linkedlist.ListNode;

/**
 *  23 移除链表元素
 *  https://leetcode.cn/problems/remove-linked-list-elements/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
@SuppressWarnings({"all"})
public class T203 {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head;
        ListNode pre = dummy;

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
