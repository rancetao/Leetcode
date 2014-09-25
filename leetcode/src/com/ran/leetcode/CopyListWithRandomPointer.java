package com.ran.leetcode;

import com.ran.leetcode.domain.RandomListNode;

import java.util.HashMap;

/**
 * Created by rantao on 9/23/14.
 */
public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return head;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode pre = newHead;
        RandomListNode node = head.next;

        // copy label and next
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }
        node = head;
        // copy random
        RandomListNode copyNode = newHead;
        while (node != null) {
            copyNode.random = map.get(node.random);
            copyNode = copyNode.next;
            node = node.next;
        }
        return newHead;
    }
}
