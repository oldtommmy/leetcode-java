package FirstExercise.linkedlist.reverse;

import FirstExercise.linkedlist.ListNode;


/**
 *  92. 反转链表 II
 *  https://leetcode.cn/problems/reverse-linked-list-ii/
 */
@SuppressWarnings({"all"})
public class T92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;

        //1.先找到 截断链表的左边一个 node
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        //2.再找到 截断链表的最后一个 node
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        //3.截断链表
        ListNode leftNode = pre.next;
        ListNode cur = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseLinkedList(leftNode);

        //4.接回原链表
        pre.next = rightNode;
        leftNode.next = cur;
        return dummy.next;

    }

    public void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }
}
