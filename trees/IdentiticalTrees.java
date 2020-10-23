package trees;

public class IdentiticalTrees
{
  public static boolean compareTree(TreeImpl root1,TreeImpl root2)
  {
    if(root1==null && root2==null) return true;
    else if(root1==null || root2==null) return false;
    else
      if(root1.val == root2.val)
      {
        return compareTree(root1.left,root2.left) && compareTree(root1.right,root2.right);
      }
      else return false;
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
    t5.right=t9;
    t6.right=t10;
    //t7.left=t11;

    TreeImpl t1_ = new TreeImpl(1);
    TreeImpl t2_ = new TreeImpl(1);
    TreeImpl t3_ = new TreeImpl(1);
    TreeImpl t4_ = new TreeImpl(1);
    TreeImpl t5_ = new TreeImpl(1);
    TreeImpl t6_ = new TreeImpl(1);
    TreeImpl t7_ = new TreeImpl(1);
    TreeImpl t8_ = new TreeImpl(1);
    TreeImpl t9_ = new TreeImpl(1);
    TreeImpl t10_ = new TreeImpl(1);
    TreeImpl t11_ = new TreeImpl(1);

    t1_.left=t2_;
    t1_.right=t3_;
    t2_.left=t4_;
    t2_.right=t5_;
    t3_.left=t6_;
    t3_.right=t7_;
    t4_.left=t8_;
   t5_.right=t9_;
    t6_.right=t10_;
    t7_.left=t11_;
    boolean isSame= compareTree(t1,t1_);
    System.out.println(isSame);
  }
}
