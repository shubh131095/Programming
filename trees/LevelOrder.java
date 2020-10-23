package trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder
{

  public static void doLevelOrder(TreeImpl root)
  {
    Queue<TreeImpl> q1 = new LinkedList<>();
    if(root==null) return;
    q1.add( root );
    while(!q1.isEmpty())
    {
        TreeImpl temp=q1.remove();
        System.out.print(temp.val + "  ");
        if(temp.left!=null)q1.add( temp.left );
        if(temp.right!=null)q1.add( temp.right );
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
    doLevelOrder(t1);
  }
}
