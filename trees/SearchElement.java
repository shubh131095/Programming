package trees;

import java.util.Stack;

// search element in Tree
public class SearchElement
{
  public static int findIt(Node root,int value)
  {
    if(root==null) return -1;
    if(root.val==value) return value;
    if(root.left!=null) return findIt( root.left,value );
    if(root.right!=null) return findIt( root.right,value );
return -1;
  }
  public static int findRec(Node root,int value)
  {
    int ans =-1;
    if(root==null) return -1;
    Stack<Node> s = new Stack<>();
     s.push(root);
     while(true)
    {
      if( s.isEmpty() ) break;
      root = s.pop();
      if(root.val==value) return root.val;
      else if(root.right!=null) s.push( root.right );
      else if(root.left!=null) s.push( root.left );
    }
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
    System.out.println( findRec(t1,12));
  }
}
