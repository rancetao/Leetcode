package com.ran.leetcode; /**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */


import com.ran.leetcode.domain.ListNode;

import java.util.List;

/**
 * Created by rantao on 9/24/14.
 */
public class MergeKSortedList {

    public ListNode mergeKLists(List<ListNode> lists) {

        if (lists == null || lists.isEmpty()) {
            return null;
        }

        int high = lists.size() - 1;
        int low = 0;

        return mergeKLists(lists, low, high);
    }

    public ListNode mergeKLists(List<ListNode> lists, int low, int high) {

        if (low > high) {
            return null;
        }

        if (low == high) {
            return lists.get(low);
        }

        int mid = low + (high - low) / 2;

        ListNode node1 = mergeKLists(lists, low, mid);
        ListNode node2 = mergeKLists(lists, mid + 1, high);
        return merge(node1, node2);
    }

    public ListNode merge(ListNode node1, ListNode node2) {

        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }

        if (node1 != null) {
            pre.next = node1;
        }
        if (node2 != null) {
            pre.next = node2;
        }
        return dummy.next;
    }

}


