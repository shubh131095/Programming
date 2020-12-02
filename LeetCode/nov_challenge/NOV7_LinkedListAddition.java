package LeetCode.nov_challenge;
// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes
// first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Follow up:
//What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//
//Example:
//
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7

// approach -1 (easy)
// reverse both and add. simple handling of all cases. reverse the list in end for ans.

//approach-2
// reccursive.
// in this you have to handle overflow condtion additonlly
// new list will be returned.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class NOV7_LinkedListAddition
{
  public static void main( String[] args )
  {
    ListNode firstList = new ListNode(9);
    firstList.next = new ListNode(8);
    firstList.next.next = new ListNode(7);
   firstList.next.next.next = new ListNode(6);

    ListNode secondList = new ListNode(7);
    secondList.next = new ListNode(6);
    secondList.next.next = new ListNode(5);

    ListNode ans = addList(firstList,secondList);
    while( ans != null ) { System.out.print(ans.val + " "); ans = ans.next; }
  }

  //apporach 1
  private static ListNode addList( ListNode l1, ListNode l2 )
  {
    if( l1 == null && l2 == null ) return null;
    else if( l1 == null ) return l2;
    else if( l2 == null ) return l1;

    l1 = reverseList(l1);
    l2 = reverseList(l2);
    int size1 = getListSize(l1);
    int size2 = getListSize(l2);
    if(size2>size1)
    {
       ListNode temp = l1;
       l1=l2;
       l2=temp;
    }

    l1 =addTheList(l1,l2,false);
    return reverseList( l1);
  }

  private static ListNode addTheList( ListNode l1, ListNode l2,boolean carry )
  {
    if(l1==null && l2==null)
    {
      if(carry) return new ListNode(1);
      else return l1;
    }
    else if(l2==null){
      if( carry ) return l1 = addTheList( l1,new ListNode(1),false );
      else return l1;
    }
    int ans;
    if(carry)
    {
      ans = l1.val+l2.val+1;
    }
    else
    {
      ans = l1.val+l2.val;
    }
    l1.val = ans%10;
    carry = ans/10 >0;
    l1.next = addTheList( l1.next,l2.next,carry );
    return l1;
  }

  private static int getListSize( ListNode root )
  {
    int a =0;
    while(root!=null)
    {
      a++;
      root = root.next;
    }
    return a;
  }

  private static ListNode reverseList( ListNode root )
  {
    ListNode temp = root.next;
    root.next=null;
    while(temp!=null)
    {
      ListNode next = temp.next;
      temp.next=root;
      root=temp;
      temp=next;
    }
    return root;
  }

  // approach2 every func declare below will be needed for approach 2 only
  public void addingList(ListNode l1,ListNode l2)
  {
    
  }
}
