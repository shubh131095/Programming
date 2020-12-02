package trees.BST;
// As the name of class suggest, you have given a sorted array and you have to create a balanced BST from that.
// Balanced BST means the height diff between LST and RST cannot be greater than 1.

// Apprach1
// insert element one by one using bst rule and if height diff of LST and RST differ by more than 1 do rotation (just like avl)

import trees.AllTraversalInOne;
import trees.PreorderTraversal;

//Apporach 2 will work on sorted array only
// start with midddle element make it root and do the same oprn for Left side and right side
// ie the left side/Right side of middle element will again become same problem
// print preOrder of tree.

// Extra Node if in place of array a unblanced binary serach tree is given, then also u can apply the same logic.
// just get the inorder of the tree and place it in a aaray and then it will become the above problem.
public class SortedArrayToBST
{
  public static void main( String[] args )
  {
    int[] arr = {10,15,20,30,40,60};
    Node ans = formBalancedBST(arr,0,arr.length-1);
    doPreOrderTraversal(ans);
  }

  private static void doPreOrderTraversal( Node root )
  {
    if(root==null) return;
    System.out.print(root.val + " ");
    doPreOrderTraversal(root.left);
    doPreOrderTraversal( root.right );
  }

  public static Node formBalancedBST(int[] arr,int start,int size)
  {
    if(start > size || start>= arr.length) return null;
    if(size==start) return new Node(arr[start]);
    Node ans = new Node();
    int val;
    if(start ==0)
    {
       val = ( (size+1) - start)/2 ;
    }
    else
    {
       val = ( (size+1) - start) / 2 + start;
    }
    ans.val = arr[val];
    ans.left = formBalancedBST(arr,start,val-1 );
    ans.right = formBalancedBST( arr,val+1,size );
    return ans;
  }
}
