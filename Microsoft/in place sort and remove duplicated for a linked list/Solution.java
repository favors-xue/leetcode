import java.util.LinkedList;

/**
in place sort and remove the duplicated for a linked list in one go
*/
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return merge(left,right);
    }

    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode c = dummy, p = n1, q = n2;
        while(p!=null || q!=null) {
            if (p==null|| q==null) {
                if (p==null) {
                    c.next = q;
                    q = q.next;
                }
                else {
                    c.next = p;
                    p = p.next;
                }
            }
            else {
                if (p.val < q.val) {
                    c.next = p;
                    p =p.next;
                }
                else if (p.val == q.val){
                    c.next = p;
                    q = q.next;
                    p = p.next;

                }
                else {
                    c.next = q;
                    q = q.next;
                }
            }
            c = c.next;
        }
        return dummy.next;
    }
}
