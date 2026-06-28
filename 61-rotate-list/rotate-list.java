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
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || head.next == null || k==0){
        return head;
       }
       int n = 1;
       ListNode last = head;
       while(last.next!=null){
        last  = last.next;
        n++;
       }
       k%=n;
       if(k==0){
        return head;
       }
       last.next =head;
       ListNode tail = head;
       for(int i = 0;i <n-k-1; i++){
        tail = tail.next;
       }
       ListNode newhead = tail.next;
       tail.next = null;

       return newhead;
    }
}