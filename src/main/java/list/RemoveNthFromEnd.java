package list;

import list.base.ListNode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur1 = dummy;
        while (n-- > 0) {
            cur1 = cur1.next;
        }
        ListNode pre2 = null, cur2 = dummy;
        while (cur1 != null) {
            pre2 = cur2;
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        pre2.next = cur2.next;
        return dummy.next;
    }
}
