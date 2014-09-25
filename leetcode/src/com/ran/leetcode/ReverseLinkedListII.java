/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 */
package com.ran.leetcode;

import com.ran.leetcode.domain.ListNode;

/**
 * @author rantao
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode preNode = dummy;

        int i = 1;
        while (preNode.next != null && i < m) {
            preNode = preNode.next;
            i++;
        }

        // if preNode.next == null
        if (i < m) {
            return head;
        }

        ListNode node = preNode.next;
        ListNode cur = node.next;

        while (cur != null && i < n) {
            ListNode next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            node.next = next;
            cur = next;
            i++;
        }

        return dummy.next;
    }
}
