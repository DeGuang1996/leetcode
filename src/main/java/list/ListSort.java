package list;

import list.base.ListNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        while (l1 != null) {
            dummy.next = l1;
            l1 = l1.next;
            dummy = dummy.next;
        }
        while (l2 != null) {
            dummy.next = l2;
            l2 = l2.next;
            dummy = dummy.next;
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

        List<ListNode> buckets = Arrays.asList(new ListNode[64]);
        Collections.fill(buckets, null);
        ListNode carry = null;
        int last = 0;
        while (head != null) {
            carry = head;
            head = head.next;
            carry.next = null;
            int i = 0;
            for (; i < last && buckets.get(i) != null; i++) {
                carry = mergeSortedList(carry, buckets.get(i));
                buckets.set(i, null);
            }
            buckets.set(i, carry);
            if (i == last) {
                last++;
            }
        }
        for (int i = 1; i < last; i++) {
            buckets.set(i, mergeSortedList(buckets.get(i), buckets.get(i - 1)));
        }
        return buckets.get(last - 1);
    }

    public static void main(String[] args) {

    }
}
