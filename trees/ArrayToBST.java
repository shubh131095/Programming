package trees;
// given an sorted array converted that into a balcnced BST, where height diff cant be greater than 1.
class TreeNode
{
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode()
  {
  }

  TreeNode( int val )
  {
    this.val = val;
  }

  TreeNode( int val, TreeNode left, TreeNode right )
  {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
public class ArrayToBST
{
  public static TreeNode getBST(int[] nums , int start,int end)
  {
    if(end<start ||  start>end )
      return null;
    TreeNode  t1 = new TreeNode();
    // int curr =(start+end)/2; // if even no then keeping extra child at right
    int curr=0;
    // if even number then keeping extra child at left.
    if( (start+end)%2==0) curr =(start+end)/2;
    else  curr =(start+end)/2+1;
    t1.val=nums[curr];
    t1.left = getBST(nums,start,curr-1);
    t1.right= getBST(nums,curr+1,end);
    return t1;
  }
  public static TreeNode sortedArrayToBST(int[] nums) {
    if(nums.length==0) return null;

    return getBST(nums,0,nums.length-1);
  }

  public static void doInorder( TreeNode root)
  {
    if(root == null) return;
    doInorder( root.left );
    System.out.print(root.val + "  " );
    doInorder( root.right );
  }

  public static void main( String[] args )
  {
    int [] arr = {-10,0,12,44,66,422};
    TreeNode t1 = sortedArrayToBST( arr );
    doInorder( t1 );
  }
}
