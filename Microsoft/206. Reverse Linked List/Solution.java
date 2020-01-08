/**
206. Reverse Linked List
Easy

2607

68

Favorite

Share
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?


step1:2->1->3->4->5
step2:

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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(-1),cur = head;
        pre.next = cur;
        ListNode tail = head;
        while(tail.next!=null) {
            tail = tail.next;
        }
        while(pre.next!=tail) {
            pre.next = cur.next;
            cur.next = tail.next;
            tail.next = cur;
            cur = pre.next;
        }
        return pre.next;

    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next ==null) return head;
        ListNode pre = null, cur = head, next = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null) {
                next = next.next;
            }
        }
        return pre;
    }
}
