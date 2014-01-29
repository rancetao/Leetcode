package com.ran.leetcode;

import com.ran.leetcode.domain.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author taor
 * @date Jan 29, 2014
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        if (head == null)
            return null;

        if (head.next == null)
            return null;

        if (head.next.next == null) {
            if (head.val == head.next.val)
                return head;
            else
                return null;
        }

        ListNode node1 = head;
        ListNode node2 = head.next.next;

        while (node1 != null && node2 != null) {

            if (node1.val != node2.val) {
                node1 = node1.next;
                if (node2.next != null) {
                    node2 = node2.next.next;
                }
                else {
                    return null;
                }
            }
            else {
                break;
            }
        }

        return node2;
    }
}
