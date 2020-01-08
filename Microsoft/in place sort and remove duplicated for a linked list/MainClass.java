import java.util.List;

public class MainClass {

    public static void main(String... args) {
        Solution s = new Solution();
        ListNode l = new ListNode(10);
        ListNode l1 = new ListNode(42);
        ListNode l2 = new ListNode(100);
        ListNode l3 = new ListNode(100);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(28);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(73);
        ListNode l9 = new ListNode(1);
        ListNode l10 = new ListNode(15);
        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        ListNode n = s.sortList(l);



    }
}
