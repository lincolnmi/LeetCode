package leetcode_109;

import java.util.ArrayList;

/**
 * Created by Jason on 2016/5/8.
 */

/**
 * Problem definition:
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/**
 * Answer:
 * recursion [head,tail)
 * use slow and fast pointer to get the middle node to split the list
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) {
            return null;
        }
        return sortedListToBST(head,null);
    }

    //[head,tail)
    private TreeNode sortedListToBST(ListNode head,ListNode tail) {
        if (head == null || head == tail) {
            return null;
        } else {
            ListNode slow = head, fast = head;
            while (fast!=tail&&fast.next!=tail) {
                slow = slow.next;
                fast = fast.next.next;
            }
            TreeNode node = new TreeNode(slow.val);
            node.left = sortedListToBST(head,slow);
            node.right = sortedListToBST(slow.next,tail);
            return node;
        }
    }
}
