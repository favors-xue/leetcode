/**
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
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode dumy = new ListNode(0);
        ListNode cur = dumy;
        ListNode tmp = null;
        do {
            tmp = findMinNode(lists);
            cur.next = tmp;
            cur = cur.next;
        }while (tmp != null);
        return dumy.next;
    }

    private ListNode findMinNode(ListNode[] lists) {
        int minValue = Integer.MAX_VALUE;
        int pos = -1;
        for (int i=0;i<lists.length;i++) {
            if (lists[i] == null) continue;
            if (lists[i].val<minValue) {
                minValue = lists[i].val;
                pos = i;
            }
        }
        ListNode res = null;
        if (pos != -1) {
            res = lists[pos];
            lists[pos] = lists[pos].next;
        }
        return res;

    }

    public ListNode mergeKListsByProrityQueue(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode dumy = new ListNode(0);
        ListNode cur = dumy;
        ListNode tmp = null;
    PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator()->)
        do {
            tmp = findMinNode(lists);
            cur.next = tmp;
            cur = cur.next;
        }while (tmp != null);
        return dumy.next;
    }

}
