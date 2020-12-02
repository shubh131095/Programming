package LeetCode.nov_challenge;
// Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class NOV15_BSTRangeSum
{
  public int rangeSumBST(TreeNode root, int low, int high)
  {
    if( root == null ) return 0;
    int sum = 0;
    if( root.val >= low && root.val <= high )
      sum = root.val;
    if( root.val > low )
      sum += rangeSumBST( root.left, low, high );
    if( root.val <= high )
      sum += rangeSumBST( root.right, low, high );

    return sum;
  }
  public static void main( String[] args )
  {
   // create bst and pass to function to get ans
  }
}
