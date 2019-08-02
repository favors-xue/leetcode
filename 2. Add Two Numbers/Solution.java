/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumyhead = new ListNode(0);
        ListNode p =l1, q = l2, curr = dumyhead;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = (p1 != null)? p1.val : 0;
            int y = (p2 != null)? p2.val : 0;
            int result = x + y + carry;
            carry = result/10;
            curr.next = new ListNode(result%10);
            curr = curr.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;

        }
        if (carry>0) {
            curr.next = new ListNode(carry);
        }
        return dumyhead.next;
    }
}
