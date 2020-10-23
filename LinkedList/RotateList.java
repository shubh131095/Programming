package LinkedList;

public class RotateList
{
  public static void rotate(Node head,int k)
  {
    Node temp=head;
    Node temp1=head;
    int size=0;
    while(temp!=null)
    {
      size++;
      temp=temp.next;
    }
    if( k>size) k=k-size;
    else if ( k==size) return;
    temp=temp1;
    while( --k>0)
    {
      temp=temp.next;
    }
    temp1=temp.next;
    temp.next=null;
    while( temp1.next!=null )
    {
      temp1=temp1.next;
    }
    temp1.next=head;
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
    rotate(n1, 2);
    Node temp3=n3;
    while( temp3 != null ) { System.out.println(temp3.data); temp3=temp3.next; }
  }
}
