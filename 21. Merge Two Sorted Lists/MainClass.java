public class MainClass {
    public static void main(String... args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        Solution s = new Solution();
        ListNode n = s.mergeTwoLists(n1,l1);

    }
}
