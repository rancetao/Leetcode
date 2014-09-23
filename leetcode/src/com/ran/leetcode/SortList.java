package com.ran.leetcode;

import com.ran.leetcode.domain.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author rantao
 *
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode midNode = findMidNode(head);
    ListNode rightPart = sortList(midNode.next);
    midNode.next = null;
    ListNode leftPart = sortList(head);

    return merge(leftPart, rightPart);
  }


  private ListNode findMidNode(ListNode head) {

    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while (left != null && right != null) {
      if (left.val < right.val) {
        cur.next = left;
        left = left.next;
      } else {
        cur.next = right;
        right = right.next;
      }
      cur = cur.next;
    }

    if (left != null)
      cur.next = left;
    else
      cur.next = right;

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(3);
    ListNode l2 = new ListNode(1);
    ListNode l3 = new ListNode(2);
    l1.next = l2;
    l2.next = l3;
    SortList sl = new SortList();
    sl.sortList(l1);
  }
}
