package trees;

import java.util.ArrayList;
import java.util.List;

// in this que you have to return a list which contains all the path of tree, i.e root->leaf
// the output list should contain all the path of leaf node.
public class AllPath
{

  private static void getPath( Node root, String path, List<String> ansList )
  {
    if (root.left==null && root.right==null)
    {
      String sb = path + "->" + root.val;
      ansList.add( sb );
    }
    else
    {
      if(root.left!=null)
      {
        getPath( root.left,path + "->" + root.val,ansList );
      }
      if(root.right!=null)
      {
        getPath( root.right,path + "->" + root.val,ansList );
      }
    }
  }

  private static List<String> findPath( Node root )
  {
    List<String> ans = new ArrayList<>();
    if(root==null) return ans;
    if(root.left!=null) getPath(root.left,root.val+"",ans);
    if(root.right!=null) getPath(root.right,root.val+"",ans);
    return ans;
  }

  public static void main( String[] args )
  {
    Node t1 = new Node(1);
    Node t2 = new Node(2);
    Node t3 = new Node(3);
    Node t4 = new Node(4);
    Node t5 = new Node(5);
    Node t6 = new Node(6);
    Node t7 = new Node(7);
    Node t8 = new Node(8);
    Node t9 = new Node(9);
    Node t10 = new Node(10);
    Node t11 = new Node(11);

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

    List<String> ans = findPath(t1);
    System.out.println(ans);
  }


}
