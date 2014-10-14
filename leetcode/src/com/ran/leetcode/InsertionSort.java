package com.ran.leetcode;

/**
 * Sort a linked list using insertion sort.
 */


import com.ran.leetcode.domain.ListNode;

/**
 * Created by rantao on 9/28/14.
 */
public class InsertionSort {

    public ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode preHead = new ListNode(-1);

        preHead.next = head;
        ListNode run = head;

        while (run != null && run.next != null) {

            if (run.val > run.next.val) {
                // find node which is not in order
                ListNode smallNode = run.next;
                ListNode pre = preHead;

                // find position for smallNode
                while (pre.next.val < smallNode.val) {
                    pre = pre.next;
                }

                ListNode temp = pre.next;
                pre.next = smallNode;

                run.next = smallNode.next;
                smallNode.next = temp;

            } else {
                // node is in order
                run = run.next;
            }
        }

        return preHead.next;
    }

    public String[] mergeSort(String[] strArr) {

        if (strArr == null || strArr.length == 1) {
            return strArr;
        }

        int start = 0;
        int end = strArr.length - 1;

        return mergeSort(strArr, start, end);

    }

    private String[] mergeSort(String[] strArr, int start, int end) {

        int mid = start + (end - start) / 2;

        mergeSort(strArr, start, mid);
        mergeSort(strArr, mid + 1, end);
        merge(strArr, start, mid, end);
        return strArr;
    }

    private void merge(String[] strArr, int start, int mid, int end) {

    }

}
