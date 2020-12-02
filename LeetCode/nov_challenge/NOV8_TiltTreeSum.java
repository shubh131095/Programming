package LeetCode.nov_challenge;
// Given the root of a binary tree, return the sum of every tree node's tilt.
//
//The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right
// subtree node values. If a node does not have a left child, then the sum of the left subtree node values is treated
// as 0. The rule is similar if there the node does not have a right child.

// examples
//Input: root = [1,2,3]
//Output: 1
//Explanation:
//Tilt of node 2 : |0-0| = 0 (no children)
//Tilt of node 3 : |0-0| = 0 (no children)
//Tile of node 1 : |2-3| = 1 (left subtree is just left child, so sum is 2; right subtree is just right child, so sum
// is 3)
//Sum of every tilt : 0 + 0 + 1 = 1

// Input: root = [4,2,9,3,5,null,7]
//Output: 15
//Explanation:
//Tilt of node 3 : |0-0| = 0 (no children)
//Tilt of node 5 : |0-0| = 0 (no children)
//Tilt of node 7 : |0-0| = 0 (no children)
//Tilt of node 2 : |3-5| = 2 (left subtree is just left child, so sum is 3; right subtree is just right child, so sum
// is 5)
//Tilt of node 9 : |0-7| = 7 (no left child, so sum is 0; right subtree is just right child, so sum is 7)
//Tilt of node 4 : |(3+5+2)-(9+7)| = |10-16| = 6 (left subtree values are 3, 5, and 2, which sums to 10; right
// subtree values are 9 and 7, which sums to 16)
//Sum of every tilt : 0 + 0 + 0 + 2 + 7 + 6 = 15


import java.util.ArrayList;
import java.util.List;

class Node
{
  int val;
  Node left;
  Node right;

  Node()
  {
    val = 0;
    left = null;
    right = null;
  }

  Node( int val )
  {
    this.val = val;
    left = null;
    right = null;
  }
}
public class NOV8_TiltTreeSum
{
  public static void main( String[] args )
  {

    Node root = new Node(4);
     root.left = new Node(2);
     root.right = new Node(9);
     root.left.left = new Node(3);
    root.left.right = new Node(5);
    //root.right.left = new Node(2);
    root.right.right = new Node(7);
   // root.left.left.left = new Node(3);
    // root.left.left.right = new Node(3);
    List<Integer> ans = new ArrayList<>();
    findTiltSum(root,ans);
    int sum = 0;
   for( int a : ans) sum+=a;
    System.out.println(sum);
  }

  private static int findTiltSum( Node root,List ans )
  {
    if(root==null) return 0;
    if(root.left==null && root.right==null) return root.val;
    int leftnum = findTiltSum( root.left,ans );
    int rightnum = findTiltSum( root.right,ans );
    int sum = Math.abs( leftnum - rightnum );
    if(sum>0) ans.add( sum );
    return leftnum + rightnum + root.val;
  }
}
