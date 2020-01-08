/**
23. Merge k Sorted Lists
Hard

3043

201

Favorite

Share
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == nul || list.length == 0) {
            return null;
        }
        if (lists.length == 1) return lists[0];
        ListNode dump = new ListNode(0);
        ListNode cur = dump;
        ListNode min = null;
        do {
            min = findMinNode(lists);
            cur.next = min;
            cur = cur.next;
        } while (min!=null);

        return dump.next;

    }

    public ListNode findMinNode(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int pos = -1;

        for (int i =0;i<lists.length;i++) {
            if (list[i] == null) continue;
            if (list[i].val<min) {
                pos = i;
                min = list[i].val;
            }
        }
        ListNode res = null;
        if (pos!=-1) {
            res = lists[pos];
            list[pos] = list[pos].next;
        }
        return res;
    }
}
