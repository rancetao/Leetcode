package com.ran.leetcode;

import com.ran.leetcode.domain.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Follow up: Can you solve it without using extra space?
 *
 * @author taor
 * @date Jan 29, 2014
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (slow == fast) {
                break;
            }
        }

        if (slow == null || fast == null) {
            return null;
        }

        // must have a cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
