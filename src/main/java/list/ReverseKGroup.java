package list;

import list.base.ListNode;

public class ReverseKGroup {

    public ListNode reverseList(ListNode head) {
        // if (head == null) {
        //     return null;
        // }
        //
        // ListNode pre = null;
        // ListNode cur = head;
        //
        // while (cur != null) {
        //     ListNode next = cur.next;
        //     cur.next = pre;
        //     pre = cur;
        //     cur = next;
        // }
        // return pre;

        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode getEnd(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // ListNode preHead = null;
        // ListNode curHead = head;
        // boolean isFirst = true;
        // ListNode res = null;
        // int curCount = 0;
        // while (head != null) {
        //     curCount++;
        //     ListNode next = head.next;
        //     if (curCount >= k) {
        //         head.next = null;
        //         if (isFirst) {
        //             res = reverseList(curHead);
        //             preHead = curHead;
        //             curHead.next = next;
        //             curHead = next;
        //             isFirst = false;
        //         } else {
        //             preHead.next = reverseList(curHead);
        //             preHead = curHead;
        //             curHead.next = next;
        //             curHead = next;
        //         }
        //         curCount = 0;
        //     }
        //     head = next;
        // }
        // return res;

        ListNode dummy = new ListNode(0, head);
        ListNode last = dummy;
        while (head != null) {
            ListNode curHead = head;
            ListNode curEnd = getEnd(head, k);
            if (curEnd == null) {
                break;
            }
            ListNode nextHead = curEnd.next;
            curEnd.next = null;

            last.next = reverseList(curHead);
            last = curHead;

            curHead.next = nextHead;
            head = nextHead;
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

}
