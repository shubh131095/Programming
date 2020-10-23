package LinkedList;

// find merge point of 2 given linked list
public class MergePoint
{
  public static void mergePoint(LinkedListImpl l1,LinkedListImpl l2)
  {
    int len1=0;
    int len2=0;
    LinkedListImpl temp1=l1;
    LinkedListImpl temp2=l2;
    while(temp1!=null)
    {
      len1++;
      temp1=temp1.next;
    }
    while(temp2!=null)
    {
      len2++;
      temp2=temp2.next;
    }
     temp1=l1;
     temp2=l2;
     int d = len1 - len2;
    if(d > 0 )
    {
     for(int i=0;i<d;i++)
     {
       temp1=temp1.next;
     }
    }
      else if(d <0){
      for(int i=0;i<(d*-1);i++)
      {
        temp2=temp2.next;
      }
    }
        else
    {
      System.out.println( "both are same" + l1 + "value at node is" + l1.value );
      return;
    }
    while(temp1!=null || temp2!=null){
      if(temp1==temp2)
      {
        System.out.println("found here" + temp1 + "value at node is"+ temp1.value);
        break;
      }
      else
        temp1=temp1.next;
      temp2=temp2.next;
    }
  }
  public static void main(String args[])
  {
    LinkedListImpl l1= new LinkedListImpl(10);
    LinkedListImpl l2= new LinkedListImpl(20);
    LinkedListImpl l3= new LinkedListImpl(30);
    LinkedListImpl l4= new LinkedListImpl(40);
    LinkedListImpl l5= new LinkedListImpl(50);
    LinkedListImpl l6= new LinkedListImpl(60);
    LinkedListImpl l7= new LinkedListImpl(500);
    LinkedListImpl l8 =new LinkedListImpl(600);
    l1.next=l2;
    l2.next=l3;
    l3.next=l4;
    l4.next=l5;
    l5.next=l6;
    l7.next=l8;
    l8.next=l1;
    mergePoint(l1,l1);


  }
}
