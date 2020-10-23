package LinkedList;

public class ReverseListReccursive
{
  public static void reverseRecussrive(Node t1,Node t2)
  {
    if( t1==null || t2==null) return;
    else
      reverseRecussrive( t2,t2.next );
    t2.next=t1;
    t1.next=null;
  }
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
    reverseRecussrive(n1,n1.next);
    Node temp3=n1;
    while( temp3 != null ) { System.out.println(temp3.data); temp3=temp3.next; }
  }
}
