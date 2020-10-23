package LinkedList;

import java.util.LinkedList;
class SinglyLinkedListNode
{
  int data;
  SinglyLinkedListNode next;
  public void add(int ans)
  {
    SinglyLinkedListNode s = new SinglyLinkedListNode();
    s.data = ans;
    s.next=null;
    this.next=s;
  }
}

public class BinaryToDecimal
{
  public static long getNumber(SinglyLinkedListNode binary)
  {
    long ans=0;
    int count =0;
    SinglyLinkedListNode s = binary;
    while (s.next!=null)
    {
      count++;
      s= s.next;
    }
     s = binary;
    while (s!=null)
    {
      ans = ans + (long)Math.pow(2,count)*(s.data);
      count--;
      s= s.next;
    }
    return  ans;
  }
  public static void main( String[] args )
  {
    SinglyLinkedListNode list = new SinglyLinkedListNode();
    list.add( 0 );
    list.add( 0 );
    list.add(0);
    list.add(0);
    list.add(0);
    list.add( 1 );
    list.add( 1 );
    list.add(1);
    list.add(1);
    list.add(1);
   long ans= getNumber(list);
    System.out.println(ans);

  }
}
