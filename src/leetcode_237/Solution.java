package leetcode_237;

/**
 * Created by Jason on 2016/5/11.
 */

/**
 * Problem definition:
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 */

/**
 * Answer:
 * use the next val to replace the current node val
 * delete the next node
 */

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
