package secondExercise.linkedlist;

import FirstExercise.linkedlist.ListNode;

public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;
        ListNode cur = headA;
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }

        if (lenA > lenB) {
            int gap = lenA - lenB;
            while (gap-- > 0) {
                headA = headA.next;
            }
        } else {
            int gap = lenB - lenA;
            while (gap-- > 0) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
