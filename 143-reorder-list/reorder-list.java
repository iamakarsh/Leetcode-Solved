/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)return;
        ListNode s=head,f=head;
        while(f.next!=null&&f.next.next!=null){
            s=s.next;f=f.next.next;
        }
        ListNode prev=null,c=s.next;s.next=null;
        while(c!=null){ListNode t=c.next;c.next=prev;prev=c;c=t;}
        ListNode p1=head,p2=prev;
        while(p2!=null){
            ListNode t1=p1.next,t2=p2.next;
            p1.next=p2;p2.next=t1;
            p1=t1;p2=t2;
        }
    }
}
