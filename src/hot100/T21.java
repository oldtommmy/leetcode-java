package hot100;

import FirstExercise.linkedlist.ListNode;

public class T21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode();
        ListNode dummy = newNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newNode.next = list1;
                list1 = list1.next;
                newNode = newNode.next;
            } else {
                newNode.next = list2;
                list2 = list2.next;
                newNode = newNode.next;
            }
        }
        while (list1 != null) {
            newNode.next = list1;
            list1 = list1.next;
            newNode = newNode.next;
        }
        while (list2 != null) {
            newNode.next = list2;
            list2 = list2.next;
            newNode = newNode.next;
        }
        return dummy.next;
    }
}
