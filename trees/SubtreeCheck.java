package trees;
// given 2 trees find whether the 1st one is subtree of 2nd tree or not

//apprach-1 find the root of subtree in main tree and then traverse both till you an say its present or not.
//approach-2 :- find any traversal of main tree and then the same traversal of subtree and check.
public class SubtreeCheck
{
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

    TreeImpl sub1=new TreeImpl(2);
    sub1.left=new TreeImpl(4);
    sub1.left.left=new TreeImpl(8);
    sub1.right=new TreeImpl(5);
    sub1.right.right=new TreeImpl(9);

    System.out.println(isSubTree(sub1,t1));
  }

  private static boolean isSubTree( TreeImpl subRoot, TreeImpl root ) // root is the main tree subRoot is subTree root
  {
    if( subRoot == null || root == null ) return false;
    if(subRoot.val==root.val) return checkSubtree(subRoot,root);
    boolean currentL=false;
    boolean currentR=false;
    if(root.left!=null) currentL=isSubTree( subRoot,root.left );
    if(root.right!=null && !currentL ) currentR= isSubTree( subRoot,root.right );
    return currentL||currentR;
  }

  private static boolean checkSubtree( TreeImpl subRoot, TreeImpl root)
  {
    if(subRoot==null && root==null) return true;
    if(subRoot==null || root==null) return false;
    if(subRoot.val!= root.val) return false;
    boolean equal = true;
    if(subRoot.left!=null)
     equal = checkSubtree( subRoot.left,root.left );
    if(equal && subRoot.right!=null) equal=checkSubtree( subRoot.right,root.right );
    return equal;
  }
}
