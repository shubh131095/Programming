
// remove all the path from the given tree which has path length < k.
package trees;
public class RemoveKPath
{
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
    t7.right=t11;
      t1= removeKpath(t1,2);
      AllTraversalInOne.levelOrderRecur( t1 );
  }

  private static Node removeKpath( Node root, int k)
  {
    if(root==null) return null;
    if(k <=0) return root;
    Node left = null;
    Node right = null;
     root.left=removeKpath( root.left,k-1 );
     root.right=removeKpath( root.right,k-1 );
   if(root.left==null && root.right==null)
   {
     root=null;
     return null;
   }
   return root;
  }
}
