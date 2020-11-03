package LeetCode.oct_challenge;
// Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note: A leaf is a node with no children.

import java.util.Stack;

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

public class OCT22_MinDepth
{
  public static int minDepth(TreeNode root) {
    if (root==null) return 0;
    return Math.min(minDepth( root.left ),minDepth( root.right )) +1;
  }

  public static int mindDepthIter(TreeNode root)
  {
    int count =0;
    int min = Integer.MAX_VALUE;
    Stack<TreeNode> s = new Stack<>();
    if(root==null) return min;
    while(root!=null || !s.isEmpty())
    {
      if( root != null )
      {
        count++;
        s.push( root );
        root = root.left;
      }
      else
      {
        TreeNode temp = s.peek().right;
        if(temp!=null)
        {
          root=temp;
        }
        else
        {
          if(count<min)  min = count;
          count--;
          temp=s.pop();
          while(!s.isEmpty() && s.peek().right.equals( temp ))
          {
            temp = s.pop();
            count--;
          }
        }
      }
    }

    return min;
    }


  public static void main( String[] args )
  {

    TreeNode t1 = new TreeNode(2);
    TreeNode t2 = new TreeNode(3);
    TreeNode t3 = new TreeNode(4);
    TreeNode t4 = new TreeNode(5);
    TreeNode t5 = new TreeNode(6);
    t1.right=t2;
    t2.right=t3;
    t3.right=t4;
    t4.right=t5;
    int count = minDepth(t1);
    System.out.println(count);
  }
  
}
