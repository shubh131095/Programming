package trees;
//find the diameter of the tree.
// diameter is the longest path between any n2 node in a tree.
// 2 approaches are coded below
// a. n2 approach, for every node -> cal height of LeftStree and RightStree and add both to get diameter and then for all node take the max.
// b. n apporach, for everynode traverse once and get the L and R tree lenghth and store in global vriable and keep max in that.
public class DiameterBT
{
  static int max_dia;
  public static int getDia(Node root)
  {
    int lheight=0;
    int rheight=0;
    if(root==null) return 0;
    if(root.left!=null)
    {
       lheight = getDia( root.left );
    }
    if(root.right!=null)
    {
       rheight = getDia( root.right );
    }
    if( lheight + rheight > max_dia)
    {
      max_dia = lheight+rheight;
    }
    return Math.max(lheight,rheight)+1;
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

    /*t1.left=t2;
    t1.right=t3;
    t2.left=t4;
    t2.right=t5;
    t3.left=t6;
    t3.right=t7;
    t4.left=t8;
    t5.right=t9;
    t6.right=t10;
    t7.left=t11;*/

    t1.left=t2;
    t1.right=t3;
    t2.left=t4;
    t2.right=t5;
    t4.left=t6;
    t6.left=t7;
    t5.right=t8;
    t8.right=t9;


     getDia(t1);
    System.out.println(max_dia);
  }
}
