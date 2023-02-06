package FirstExercise.linkedlist.design;

import FirstExercise.linkedlist.ListNode;

/**
 *  LeetCode 707 设计链表
 *  https://leetcode.cn/problems/design-linked-list/
 */
@SuppressWarnings({"all"})
class MyLinkedList {

    ListNode head = new ListNode();//虚拟头结点
    int size; //记录链表长度

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    //获取index个结点的值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }
        size++;

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }

        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
