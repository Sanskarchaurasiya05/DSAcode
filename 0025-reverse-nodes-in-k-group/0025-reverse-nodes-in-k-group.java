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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head , prevnode=null;
              while(temp!=null){
                // find kthnode to reverse the linkedlist
                    ListNode kthnode=foundkthnode(temp,k);
                    if(kthnode==null){
                        if(prevnode!=null)
                        prevnode.next=temp;
                    break;
                    }
  //   store the next node of kthnode for linking the list to reverse list
                  ListNode nextNode=kthnode.next;
                  kthnode.next=null;
                  reverse(temp);
                  if(temp==head)
                  head=kthnode;
                     else{
                        prevnode.next=kthnode;
                     }
                      prevnode=temp;
                        temp=nextNode;
 }
         return head;
    }

    private static ListNode foundkthnode(ListNode head , int k){
                    k-=1;
                    while(head!=null && k>0){
                        head=head.next;
                        k--;
                    }
                    return head;
}

private static void reverse(ListNode head){
    ListNode curr=head , prev=null;
    while(curr!=null){
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
}

}