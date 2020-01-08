
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example:

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.
 

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
        int cache = 0;
        ListNode res = new ListNode(0);
        while(l1!=null && l2!=null) {
            int sum = l1.val + l2.val+cache;
            ListNode node = new ListNode(sum/10);
            cache = sum%10;
            l1 = l1.next;
            l2 = l2.next;
            res.next = node;
            res = res.next;
        }
        while (l1!=null) {
            res.next = l1;
        }
        while (l2!=null) {
            res.next = l2;
        }
        return res;
        
    }

    public class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {
             val = x;
        }
    }
}