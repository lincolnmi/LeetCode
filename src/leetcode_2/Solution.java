package leetcode_2;

/**
 * Created by Jason on 2016/4/26.
 */

/**
 * Problem definition:
 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

/**
 * Answer:
 * similar like add two string, add node by node
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null,current = null;
        while (l1!=null||l2!=null||carry==1) {
            carry += (l1==null)?0:l1.val;
            carry += (l2==null)?0:l2.val;
            if (head==null) {
                head = new ListNode(carry%10);
                current = head;
            } else {
                current.next = new ListNode(carry%10);
                current = current.next;
            }
            carry /= 10;
            l1 = (l1==null)?null:l1.next;
            l2 = (l2==null)?null:l2.next;
        }
        return head;
    }

}
