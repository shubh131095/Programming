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
    if(root == null) return;
    TreeImpl temp=root;
    while(true)
    {
      while(temp!=null)
      {
        s1.push( temp );
        temp=temp.left;
      }
      if(s1.isEmpty()) break;
      else
      {
        temp=s1.peek();
        if(temp.right==null)
        {
          temp = s1.pop();
          System.out.print( temp.val + " " );
        }
          temp = temp.right;
      }
    }
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
