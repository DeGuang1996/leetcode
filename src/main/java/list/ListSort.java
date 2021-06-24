package list;

import list.base.ListNode;

import java.util.*;

public class ListSort {

    public static ListNode mergeSortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null) {
            dummy.next = l1;
        } else {
            dummy.next = l2;
        }
        return res.next;
    }

    /**
     * 归并排序，主要思想是开64个桶，两两有序合并，以2^n迭代，理论上可存2^64-1个数
     * @param head  链表头
     * @return      排序过后的链表头
     */
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode[] buckets = new ListNode[64];
        Arrays.fill(buckets, null);

        int last = 0;
        while (head != null) {
            ListNode carry = head;
            head = head.next;
            carry.next = null;

            int begin = 0;
            for (; begin < last && buckets[begin] != null; begin++) {
                carry = mergeSortedList(carry, buckets[begin]);
                buckets[begin] = null;
            }
            buckets[begin] = carry;
            if (begin == last) {
                last++;
            }
        }
        for (int i = last; i > 0; i--) {
            buckets[i - 1] = mergeSortedList(buckets[i], buckets[i - 1]);
            buckets[i] = null;
        }
        return buckets[0];
    }

    public static void main(String[] args) {
        ListNode begin = new ListNode(0, null);
        ListNode head = begin;
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            begin.next = new ListNode(random.nextInt(1000), null);
            begin = begin.next;
        }
        ListNode res = mergeSort(head.next);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
