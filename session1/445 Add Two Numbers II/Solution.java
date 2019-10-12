class Solution {
    public ListNode reverseNodes(ListNode l){
        ListNode cur=l;
        ListNode prev=null;
        ListNode third=null;
        while(cur!=null){
            third=cur.next;
            cur.next=prev;
            prev=cur;
            cur=third;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        l1=reverseNodes(l1);
        l2=reverseNodes(l2);
        ListNode result=new ListNode(0);
        ListNode pointer=result;
        int carry=0;
        while(l1!=null&&l2!=null){
            result.next=new ListNode((carry+l1.val+l2.val)%10);
            carry=(carry+l1.val+l2.val)/10;
            result=result.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            result.next=new ListNode((carry+l1.val)%10);
            carry=(carry+l1.val)/10;
            result=result.next;
            l1=l1.next;
        }
        while(l2!=null){
            result.next=new ListNode((carry+l2.val)%10);
            carry=(carry+l2.val)/10;
            result=result.next;
            l2=l2.next;
        }
        if(carry!=0){
            result.next=new ListNode(carry);
        }
        return reverseNodes(pointer.next);
    }
}
