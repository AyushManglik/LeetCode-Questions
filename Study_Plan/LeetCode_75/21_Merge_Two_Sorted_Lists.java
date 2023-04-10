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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = null,tail = null;
        if(a==null) 
            return b;
        else if(b==null) 
            return a;
        else if(a.val<=b.val) {
            head = tail = a;   
            a = a.next;
        }
        else{ 
            head = tail = b;   
            b = b.next;
        }

        while(a!=null && b!=null){
            if(a.val<=b.val){
                tail.next = a;   
                tail = a;   
                a = a.next; }
            else{
                tail.next = b;   
                tail = b;   
                b = b.next;  } 
        }
        if(a==null) 
            tail.next = b;
        else 
            tail.next = a;
        return head;
    }
}
