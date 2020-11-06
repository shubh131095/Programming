package array;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Test
{
  public static int getDecimalValue(ListNode head) {
    if(head==null) return 0;
    int ans =0;
    int size=0;
    ListNode temp = head;
    while(temp.next!=null)
    {
      size++;
      temp = temp.next;
    }
    temp=head;
    for(int i=size;i<=0;i--)
    {
      ans = ans + (int)( Math.pow(2,i)*temp.val);
      temp = temp.next;
    }
    return ans;
  }
  public static void main( String[] args )
  {
    ListNode ls = new ListNode(1);
    ListNode ls1 = new ListNode(0);
    ListNode ls2 = new ListNode(1);
    ls.next = ls1;
    ls1.next=ls2;
    int ans = getDecimalValue( ls );
    System.out.println(ans);
  }
}
