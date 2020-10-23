package trees;

public class SizeOfTree
{
  public static int countNodes(TreeImpl root)
  {
    if( root == null )
      return 0;
    else
      return 1 + countNodes(root.left) + countNodes(root.right);
  }
  public static void main( String[] args )
  {
    TreeImpl t1 = new TreeImpl(1);
    TreeImpl t2 = new TreeImpl(1);
    TreeImpl t3 = new TreeImpl(1);
    TreeImpl t4 = new TreeImpl(1);
    TreeImpl t5 = new TreeImpl(1);
    TreeImpl t6 = new TreeImpl(1);
    TreeImpl t7 = new TreeImpl(1);
    TreeImpl t8 = new TreeImpl(1);
    TreeImpl t9 = new TreeImpl(1);
    TreeImpl t10 = new TreeImpl(1);
    TreeImpl t11 = new TreeImpl(1);

    t1.left=t2;
    t1.right=t3;
    t2.left=t4;
    t2.right=t5;
    t3.left=t6;
    t3.right=t7;
    t4.left=t8;
   /* t5.right=t9;
    t6.right=t10;
    t7.left=t11;*/
    int size=countNodes(t1);
    System.out.println(size);
  }
}
