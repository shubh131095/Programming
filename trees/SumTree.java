package trees;
// given a tree find whether its sum tree or not
// sum tree -> for every node except leaf, the value of root = sum of value of l + r subtree.
public class SumTree
{

  public static void main( String[] args )
  {
    Node t1 = new Node(106);
    Node t2 = new Node(23);
    Node t3 = new Node(30);
    Node t4 = new Node(11);
    Node t5 = new Node(1);
    Node t6 = new Node(15);
    Node t7 = new Node(5);
    Node t8 = new Node(6);
    Node t9 = new Node(7);
    Node t10 = new Node(8);
    Node t11 = new Node(1);
//                                                                        106
//	                                                        23									           30
//
//												                          		11      1                       5
//
//											                          5         6											7           8
    t1.left=t2;
    t1.right=t3;
    t2.left=t4;
    t2.right=t5;
    t3.left=t6;
    t3.right=t11;
    t4.left=t7;
    t4.right=t8;
    t6.left=t9;
    t6.right=t10;
    System.out.println(isSumTree(t1));
  }

  private static boolean isSumTree( Node root )
  {
    if(root==null) return false;
    int leftSum=findSum(root.left);
    int rightSum=findSum(root.right);
    if(leftSum+rightSum==root.val) return true;
    else
      return false;
  }

  private static int findSum( Node root )
  {
    if(root.left==null && root.right==null) return root.val;
    int leftSum=0;
    int rightSum=0;

    if(root.left!=null)
      leftSum=findSum( root.left );
    if(root.right!=null)
      rightSum=findSum( root.right);

    if(leftSum+rightSum==root.val) return leftSum+rightSum+root.val;
    else
      return leftSum - rightSum ;
  }
}
