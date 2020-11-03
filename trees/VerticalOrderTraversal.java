package trees;
// in vertical order each node is assigned a value.
// root starts at 0;
// any value to left will get parent value -1
// any value to right will get parent value +1
// like wise all the nodes will have certain value, you have to print nodes value which has min range value to max range value.


// method 1 is n2 solution. in this first we are finding the range of horizontal values ( like -2 to 3) and then printing all nodes from that range.
public class VerticalOrderTraversal
{
  static int max;
  static int min;
  private static void getVerticalRange( Node root,int currentIndex )
  {
    if(root==null) return;
    if(currentIndex < min) min = currentIndex;
    if(currentIndex > max) max = currentIndex;
    if(root.left!=null) getVerticalRange( root.left,currentIndex-1 );
    if(root.right!=null) getVerticalRange( root.right,currentIndex+1 );
  }

  private static void printVerticalOrder( Node root, int min_, int max_ )
  {
    for(int i=min_;i<=max_;i++)
    {
      printNodesAtKRange(root,0,i);
    }
  }

  private static void printNodesAtKRange( Node root,int start, int range )
  {
    if(root==null) return;
    if( start == range ) { System.out.print(root.val + " "); }
      if(root.left!=null) printNodesAtKRange( root.left,start-1,range );
      if(root.right!=null) printNodesAtKRange( root.right,start+1,range );
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
    getVerticalRange(t1,0);
    printVerticalOrder(t1,min,max);
  }

 }
