package trees;
// We are given a binary tree (with root node root), a target node, and an integer value K.
//
//Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned
// in any order.
//

import java.util.ArrayList;
import java.util.List;

public class NodeKDistanceNode
{
  public static void findNodes(Node root,int k,List<Integer> ans)
  {
if(k==0)
{
  ans.add( root.val );
  return;
}
if(root.left!=null) findNodes( root.left,k-1,ans );
    if(root.left!=null) findNodes( root.right,k-1,ans );
  }
/*  public static List<Integer> distanceK( Node root, Node target, int K )
  {
  }*/
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
   // List<Integer> ans = distanceK( t1 , t5, 3); // find all nodes which is 3 distance from 2nd paramter
  }
}
