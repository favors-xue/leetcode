/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode point = new ListNode(0);
        ListNode head = point;
        while(l1!=null && l2!=null) {
            if (l1.val <= l2.val ) {
                point.next = l1;
                l1 = l1.next;
            }
            else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if (l1==null) {
            while(l2!=null) {
                point.next = l2;
                l2 = l2.next;
                point = point.next;
            }
        }
        if (l2==null) {
            while(l1!=null) {
                point.next = l1;
                l1 = l1.next;
                point = point.next;
            }
        }
        return head.next;
    }
}
