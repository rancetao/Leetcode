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

        if (head != null && head.next != null) {

            ListNode slow = head;
            ListNode fast = head;

            //use a fast and slow pointer to break the link to two parts.
            while (fast != null && fast.next != null && fast.next.next != null) {
                //why need third/second condition?
                System.out.println("pre " + slow.val + " " + fast.val);
                slow = slow.next;
                fast = fast.next.next;
                System.out.println("after " + slow.val + " " + fast.val);
            }

            ListNode second = slow.next;
            slow.next = null;// need to close first part

            // now should have two lists: head and fast

            // reverse order for second part
            second = reverseOrder(second);

            ListNode p1 = head;
            ListNode p2 = second;

            //merge two lists here
            while (p2 != null) {
                ListNode temp1 = p1.next;
                ListNode temp2 = p2.next;

                p1.next = p2;
                p2.next = temp1;

                p1 = temp1;
                p2 = temp2;
            }
        }
    }

    public static ListNode reverseOrder(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode curr = head.next;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        // set head node's next
        head.next = null;

        return pre;
    }


}
