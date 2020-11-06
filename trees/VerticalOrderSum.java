package trees;
// in this problem,you have to print the vertical order some for each horizontal value.
// so if horizontal range is -1 to 2 output is like -> -1 -> sum , 0 -> sum , 1 -> sum , 2 -> sum.
// we have discussed vertical travesal same can be used here , or a new approach for doing vertical traversal can also be used
// we can use Doubly Linked List for storing the range and each node will point to range using next and prev pointer.
// the data field can be created in 2 ways
// 1. if data filed is again a list , we can store range in root and all the values in its nodes/sum
//2. if we store the sum in root or data field and we can keep the track of min and max index , for printing range.
class DoublyNode
{
  int value;
  DoublyNode next;
  DoublyNode prev;

  DoublyNode()
  {
    value =0;
    next=null;
    prev=null;
  }
  DoublyNode(int value)
  {
    this.value =value;
    next=null;
    prev=null;
  }
}
public class VerticalOrderSum
{
  static int min;
  static int max;
  VerticalOrderSum()
  {
    min=0;
    max=0;
  }
  public static void main( String[] args )
  {
    Node t1 = new Node(1);
    Node t2 = new Node(2);
    Node t3 = new Node(3);
    Node t4 = new Node(4);
    Node t5 = new Node(5);
    Node t6 = new Node(6);
    Node t7 = new Node(7);
    Node t8 = new Node(8);
    Node t9 = new Node(9);
    Node t10 = new Node(10);
    Node t11 = new Node(11);

    t1.left=t2;
    t1.right=t3;
    t2.left=t4;
    t2.right=t5;
    t3.left=t6;
    t3.right=t7;
    t4.left=t8;
    t5.right=t9;
    t6.right=t10;
    t7.left=t11;
    Character dir = 'x';
    DoublyNode ans = getVerticalSum(t1,0,null,null,dir);
   while(ans.prev!=null)
   {
     ans = ans.prev;
   }
   while(ans!=null && min<=max)
   {
     System.out.println("range " + min + " :- " + ans.value + " ");
     min=min+1;
     ans=ans.next;
   }
  }

  private static DoublyNode getVerticalSum( Node root,int hor_range,DoublyNode list , DoublyNode prev_list , Character dir)
  {
   if(root==null) return null;
    if(min>hor_range) min=hor_range;
    if(max<hor_range) max=hor_range;
   if(list==null)
   {
     list = new DoublyNode( root.val );
     if( dir == 'L') list.next=prev_list;
     else if(dir == 'R') list.prev=prev_list;
   }
   else
   {
     list.value = list.value+root.val;
   }

   if(root.left!=null) list.prev = getVerticalSum( root.left,hor_range-1,list.prev,list,'L' );
    if(root.right!=null) list.next = getVerticalSum( root.right,hor_range+1,list.next,list,'R' );
    return list;
  }
}
