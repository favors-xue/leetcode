public class MainClass {

    public static void main(String... args) {
        ListNode l = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(7);
        l4.next = l5;
        l5.next = l6;
        ListNode l7 = new ListNode(6);
        ListNode l8 = new ListNode(9);
        l7.next = l8;
        ListNode[] t = {l,l4,l7};
        Solution s = new Solution();
        ListNode a = s.mergeKLists(t);
    }
}
