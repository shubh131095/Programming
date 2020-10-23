/*
Problem Statement
Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
Input:
  i.like.this.program.very.much
  pqr.mno

  Output:
  much.very.program.this.like.i
  mno.pqr
*/

package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
public class StringWordReverse
{
  public static void main( String args[] )
  {

    TreeNode t4 = new TreeNode( 4 );
    TreeNode t5 = new TreeNode( 5 );
    TreeNode t6 = new TreeNode( 6 );
    TreeNode t7 = new TreeNode(7);

    TreeNode t2 = new TreeNode( 2,t4,t5 );
    TreeNode t3 = new TreeNode( 3,t6,t7 );
    TreeNode t1 = new TreeNode( 1,t2,t3 );
    Stack<TreeNode> s1 = new Stack();
    s1.push(t1);
    List<Integer> l1 = new ArrayList<>();
    TreeNode t = t1;
    while(!s1.isEmpty())
    {
      if(t.left!=null)
      {
        s1.push(t.left);
        t= t.left;
      }
       else if( t.right!=null)
      {
        t=t.right;
        l1.add(s1.pop().val);
        s1.push( t );
      }
      else
      {
        l1.add(s1.pop().val);
        if(!s1.isEmpty())
        {
          t = s1.peek();
          t.left = null;
        }
      }
    }
    System.out.println(l1);
  }
}


