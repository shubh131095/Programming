package LinkedList;

public class ReverseList
{
  public static void main( String[] args )
  {
    Node n1= new Node( 1);
    Node n2= new Node( 2);
    Node n3= new Node( 3 );
    Node n4= new Node( 4 );
    Node n5= new Node(5 );
    Node n6= new Node( 6 );
    n1.next=n2;
    n2.next=n3;
    n3.next=n4;
    n4.next=n5;
    n5.next=n6;
    Node temp1 = n1;
    Node temp3=null;
    while(temp1!=null)
    {
      Node temp2 = temp1.next;
      temp1.next=temp3;
      temp3=temp1;
      temp1=temp2;
    }
    // head = temp3;
    while( temp3 != null ) { System.out.println(temp3.data); temp3=temp3.next; }

  }
}
