package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathToSpecificNode
{
  public static boolean getpath(Node root,Node ele,List<Integer> list)
  {

    list.add(root.val);
    boolean ans=false;
    if(root.val==ele.val) return true;
   else if(root.left==null && root.right==null)
    {
      list.remove( list.size()-1) ;
      return false;
    }
    if(root.left!=null && !ans)
    {
       ans = getpath( root.left,ele,list );
    }
     if(root.right!=null  && !ans)
    {
       ans= getpath( root.right,ele,list );
    }
     if(ans)
     {
       return true;
     }
     else
     {
       list.remove( list.size()-1) ;
       return false;
     }
  }
  public static ArrayList<Integer> findThePath(Node root,Node ele)
  {
    if(root==null) return null ;
    ArrayList<Integer> ans = new ArrayList<>();
    getpath(root,ele,ans);
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

    findThePath(t1,t10);
  }
}
