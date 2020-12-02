package LinkedList;
// Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

class ListNode {
  int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class MergeSortedLIst
{
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if (l2 == null) { return l1; }
    if (l1 == null) { return l2; }
    if(l1.val > l2.val)
    {
      ListNode shift = l1;
      l1=l2;
      l2=shift;
    }
    ListNode head = l1;
    ListNode prev=l1;
    while(l1!=null && l2!=null)
    {
      if(l1.val <= l2.val)
      {
        prev = l1;
        l1 = l1.next;
      }
      else
      {
        ListNode temp = l2;
        l2 = l2.next;
        prev.next=temp;
        temp.next=l1;
        prev = temp;
      }
    }
    if(l2!=null) {prev.next=l2;}
    return head;
  }

  // create main and call the function.
}
