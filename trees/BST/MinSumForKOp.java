package trees.BST;
// Minimize array sum by replacing greater and smaller elements of pairs by half and double of their values
// respectively atmost K times
//Last Updated: 08-12-2020
//Given an array arr[] consisting of N positive integers and an integer K, the task is to find the minimum possible
// array sum that can be obtained by repeatedly selecting a pair from the given array and divide one of the elements
// by 2 and multiply the other element by 2, at most K times.

import java.util.Arrays;

// The BF method is simple where we can at every loop find min and max and do opration.
// Approach2
class BST
{
  int val;
  BST left;
  BST right;

  public BST( int val_ )
  {
    val = val_;
    left = null;
    right = null;
  }
  public BST( )
  {
  }
}
public class MinSumForKOp
{
  static int fin_sum;
  public static void main( String[] args )
  {
    int ip[] = {5, 1, 10, 2, 3};
    fin_sum = Arrays.stream( ip ).sum();
    int k = 2;
    getMinSum(ip,k);
  }

  private static int getMinSum( int[] ip, int k )
  {
    if (k==0)
      return fin_sum;
    BST root = new BST(ip[0]);
    for(int i=1;i< ip.length;i++)
    root = convertTOBSTRec( root,ip[i] );

     return 0;
  }

  private static BST convertTOBSTRec( BST root, int i)
  {
    if(root==null)
      return new BST(i);

    if(root.val < i)
        root.right= convertTOBSTRec( root.right,i );
    else
      root.left = convertTOBSTRec( root.left,i );
    return root;
  }

  // since the array is not sorted,we can pick any array index as root.
  // otherwise, we can sort the aaray and then select middle element as root that will always return a balanced BST.
  private static BST convertTOBST( int[] ip_)
  {
    BST bst = new BST();
    BST root = new BST();
    root=bst;
    bst.val = ip_[0];
    for(int i=1;i<ip_.length;i++)
    {
      BST curr = new BST();
      curr.val = ip_[i];
      bst=root;
      while(true)
      {

          if( curr.val<bst.val)
          {
            if(bst.left==null)
            {
              bst.left = curr;
              break;
            }
            else
              bst=bst.left;
          }
        else if( curr.val > bst.val )
        {
          if(bst.right==null)
          {
            bst.right = curr;
            break;
          }
          else
            bst=bst.right;
        }
      }
    }
    doInorder(root);
    return root;
  }

  private static void doInorder( BST root )
  {
    if(root==null) return;
    doInorder( root.left );
    System.out.println(root.val);
    doInorder( root.right );
  }
}
