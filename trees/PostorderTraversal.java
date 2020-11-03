package trees;

import java.util.Stack;

public class PostorderTraversal
{
  public static void getPOSTOrderRecursive( TreeImpl root)
  {
    if(root == null) return;
    getPOSTOrderRecursive( root.left );
    getPOSTOrderRecursive( root.right );
    System.out.print(root.val + "  " );
  }
  public static void getPOSTOrderIterative(TreeImpl root)
  {
    Stack<TreeImpl> s1 = new Stack<>();
    Stack<TreeImpl> s2 = new Stack<>();
    if(root == null) return;
    s1.push( root );
    // 1st apporach using 2 stack
    while(true)
    {
      if(s1.isEmpty()) break;
      TreeImpl temp = s1.pop();
     s2.push( temp );
     if(temp.left!=null) s1.push( temp.left );
      if(temp.right!=null) s1.push( temp.right );
    }
    while(!s2.isEmpty())
    {
      System.out.print(s2.pop().val + "  ");
    }
    // 2nd approach using 1 stack

    /*while(root!=null || !s.isEmpty())
    {
      if(root!=null)
      {
        s.push( root );
        root = root.left;
      }
      else
      {
        Node temp = s.peek().right;
        if(temp==null)
        {
          temp=s.pop();
          System.out.print( temp.val + " ");
          while(!s.isEmpty()&& temp == s.peek().right)
          {
            temp = s.pop();
            System.out.print( temp.val + " ");
          }
        }
        else
        {
          root = temp;
        }

      }
    }*/
  }

  public static void main( String[] args )
  {
    TreeImpl t1 = new TreeImpl(1);
    TreeImpl t2 = new TreeImpl(2);
    TreeImpl t3 = new TreeImpl(3);
    TreeImpl t4 = new TreeImpl(4);
    TreeImpl t5 = new TreeImpl(5);
    TreeImpl t6 = new TreeImpl(6);
    TreeImpl t7 = new TreeImpl(7);
    TreeImpl t8 = new TreeImpl(8);
    TreeImpl t9 = new TreeImpl(9);
    TreeImpl t10 = new TreeImpl(10);
    TreeImpl t11 = new TreeImpl(11);

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
    getPOSTOrderRecursive(t1);
    System.out.println("");
    getPOSTOrderIterative(t1);
  }
}
