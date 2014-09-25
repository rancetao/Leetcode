package com.ran.leetcode;

import com.ran.leetcode.domain.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each
 * of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *
 * @author taor
 * @date Jan 29, 2014
 */
public class AddTwoNumber {

    public static void print(ListNode node) {

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String args[]) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        // reverse(l1);
        print(l5);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list = null, tail = null;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum %= 10;
            if (list == null) {
                list = new ListNode(sum);
                tail = list;
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return list;
    }

    public void reverse(ListNode node) {

        ListNode previous = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }
    }
}
