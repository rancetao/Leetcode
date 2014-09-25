package com.ran.leetcode;
/**
 *
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */


import com.ran.leetcode.domain.ListNode;

/**
 * Created by rantao on 9/25/14.
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode end = head.next;
        while (end != null) {
            if (end.next == null) {
                break;
            } else {
                end = end.next;
            }
        }

        reorderList(head, end);
    }

    public void reorderList(ListNode head, ListNode end) {


    }
}
