package LinkedList;
class Node
{
  int data;
  Node next;

  Node( int d )
  {
    data = d;
    next = null;
  }
}
public class MiddleElement
{
  static void getMiddle(Node head)
  {
    Node point1=head;
    Node point2=head;
    while(point2!=null)
    {
      if(point2.next !=null)
      {
        if(point2.next.next!=null)
        {
          point2=point2.next.next;
          point1=point1.next;
        }
        else
        {
          point1 = point1.next;
          point2 = point2.next;
        }
      }
      else
        break;
    }
    System.out.println(point1.data);
  }

  public static void main( String[] args )
  {
    Node n1= new Node( 6);
    Node n2= new Node( 49);
    Node n3= new Node( 3 );
    Node n4= new Node( 4 );
    Node n5= new Node(5 );
    Node n6= new Node( 6 );
    n1.next=n2;
    n2.next=n3;
    n3.next=n4;
   /* n4.next=n5;*/
    /*n5.next=n6;*/

    getMiddle(n1);
  }
}

