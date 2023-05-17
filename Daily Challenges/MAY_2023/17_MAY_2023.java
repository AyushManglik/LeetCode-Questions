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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //Step1: Find middle of LL
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

    //Step2: reverse LL fom slow(middle) pointer till end
        ListNode prv = null;
        while(slow != null){
            ListNode nxt = slow.next;
            slow.next = prv;
            prv = slow;
            slow = nxt;
        }

        ListNode l1 = head;
        ListNode l2 = prv;
        int ans = Integer.MIN_VALUE;
        while(l1 != null && l2 != null){
            int t = l1.val + l2.val;
            ans = Math.max(ans,t);
            l1= l1.next;
            l2= l2.next;
        }
        return ans;
    }
}
