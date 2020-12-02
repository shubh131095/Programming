package trees;

import java.util.LinkedList;
import java.util.Queue;

// given two nodes of a tree tell whether they are cousins or not.
// cousins -> same level different parent.

//approach
// find the least common anccestor for both node and check if its not the parent.
public class CousinNode
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
    t5.right=t9;
    t6.right=t10;
    t7.left=t11;

    System.out.println(findTheCousin(t1,t8.val,t5.val));
  }
  private static boolean findTheCousin( Node root, int node1, int node2 )
  {
    if(root==null) return false;
    int level1 = findNodeLevel(root,node1,0,node2);
    int level2 =-10;
    if(level1>0) level2 = findNodeLevel(root,node2,0,node1);
     else return false;
    if(level1==level2 ) return true;
    else return false;

  }

  private static int findNodeLevel( Node root, int node1, int level, int cousinNode )
  {
    if(root==null) return 0;
    if(root.val==node1) return level;
    if(root.left!=null && root.right!=null)
    {
      if( (root.left.val==node1 || root.right.val==node1) && (root.left.val==cousinNode || root.right.val==cousinNode))
      {
        return -1;
      }
    }
    int finalLevel=0;

    if(root.left!=null) finalLevel = findNodeLevel( root.left,node1,level+1,cousinNode );
    if( root.left!=null && finalLevel==0)  finalLevel=findNodeLevel( root.right,node1,level+1,cousinNode );
    return finalLevel;
  }

}
