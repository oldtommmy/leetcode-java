package FirstExercise.linkedlist.intersection;

import FirstExercise.linkedlist.ListNode;


/**
 * 160. 相交链表
 */
@SuppressWarnings({"all"})
public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        int bSize = 0, aSize = 0;
        while (curA != null) { //求A长度
            aSize++;
            curA = curA.next;
        }

        while (curB != null) { //求B长度
            bSize++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        //让 curA 为长链表的 head
        if (bSize > aSize) {
            int tmpSize = bSize;
            bSize = aSize;
            aSize = tmpSize;

            ListNode tmp = curA;
            curA = curB;
            curB = tmp;
        }
        int gap = aSize - bSize;

        //让A先走gap步
        while (gap-- > 0){
            curA = curA.next;
        }

        //一起遍历
        while (curA != null) {
            if (curA == curB) { //相等时直接return
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
