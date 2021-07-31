package list;

import list.base.ListNode;

import java.util.HashSet;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // HashSet<ListNode> hashSet = new HashSet<>();
        // ListNode head = headA;
        // while (head != null) {
        //     hashSet.add(head);
        //     head = head.next;
        // }
        // head = headB;
        // while (head != null) {
        //     if (hashSet.contains(head)) {
        //         return head;
        //     }
        //     head = head.next;
        // }
        // return null;

        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptrA = headA, ptrB = headB;
        while (ptrA != ptrB) {
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;
    }
}
