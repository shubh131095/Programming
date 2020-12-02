package LeetCode.nov_challenge;
// Given the root of a binary tree, find the maximum value V for which there exist different nodes A and B where V =
// |A.val - B.val| and A is an ancestor of B.
//
//A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.

//example
// Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
//Output: 7
//Explanation: We have various ancestor-node differences, some of which are given below :
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

// Input: root = [1,null,2,null,0,3]
//Output: 3

//TODO -> not completed
public class NOV9_MaxAncesstorDiffernce
{
  static int sum = Integer.MIN_VALUE;
  public static void main( String[] args )
  {

    Node root = new Node(8);
    root.left = new Node(3);
    root.right = new Node(10);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
   // root.right.left = new Node(2);
    root.right.right = new Node(14);
    // root.left.left.left = new Node(3);
     //root.left.left.right = new Node(3);
    root.left.right.left = new Node(4);
    root.left.right.right = new Node(7);
    root.right.right.left = new Node(13);

    findMaxAnccDiff(root);
    System.out.println(sum);
  }

  private static void findMaxAnccDiff( Node root )
  {
    if(root==null) return ;
    getVal(root,root.val,root.val);
  }

  private static void getVal( Node root, int min, int max )
  {
    if(root == null) return ;
    max = Math.max( root.val,Math.max( min,max ) );
    min = Math.min( root.val,Math.min( min,max ) );
    getVal( root.left,min,max );
    getVal( root.right,min,max );
    sum =  Math.max( sum,max-min);
  }


}
