package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
                           1
                 2                    3
            4        5           6         7
         8              9         10     11
 */
// above tree is used a example for all traversal
class Node
{
  int val;
  Node left;
  Node right;
  
  Node()
  {
    val = 0;
    left = null;
    right = null;
  }
  Node(int val)
  {
    this.val = val;
    left = null;
    right = null;
  }
}
public class AllTraversalInOne
{
  // Inorder -> Left Root Right
  public static void inOrderRecur(Node root){
    if(root==null) return;
    inOrderRecur(root.left);
    System.out.print(root.val + " ");
    inOrderRecur( root.right );

  }
  public static void inOrderIter(Node root){
    Stack<Node> s = new Stack<>();
    if(root == null) return;
    while(true)
    {
      while(root!=null)
      {
        s.push(root);
        root = root.left;
      }
      if(s.isEmpty()) return;
      Node temp = s.pop();
      System.out.print(temp.val+ " ");
      if(temp.right!=null)
      {
        root = temp.right;
      }
      else
      {
        root = null;
      }
    }
  }
   // preOrder Root -> Left -> Right

  public static void preOrderRecur(Node root){
    if(root==null) return;
    System.out.print(root.val + " ");
    preOrderRecur(root.left);
    preOrderRecur( root.right );

  }
  public static void preOrderIter(Node root){
    Stack<Node> s = new Stack<>();
    if(root == null) return;
   s.push(root);
     while(true)
     {
       if(s.isEmpty()) return;
       root = s.pop();
       System.out.print(root.val + " ");
       if( root.right!=null) s.push(root.right);
       if(root.left!=null) s.push( root.left );
     }

  }

  // postOrder Left -> Right -> Root

  public static void postOrderRecur(Node root){
    if(root==null) return;
    postOrderRecur(root.left);
    postOrderRecur( root.right );
    System.out.print(root.val + " ");

  }
  public static void postOrderIter(Node root){
    Stack<Node> s = new Stack<>();
    if(root == null) return;
    while(root!=null || !s.isEmpty())
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
    }
  }
 // level Order
 public static void levelOrderRecur(Node root)
 {
   if(root == null) return;
   int height = getTreeHeight(root);
   for(int i=0;i<height;i++)
   {
     printNodeForLevel(root,i);
   }
 }
  public static int getTreeHeight(Node root)
  {
    if(root== null) return 0;
    return Math.max(getTreeHeight(root.left),getTreeHeight(root.right))+1;
  }
  public static void printNodeForLevel(Node root,int level)
  {
    if( level == 0 ) { System.out.print(root.val + " "); return;}
    if(root.left!=null)printNodeForLevel( root.left,level-1 );
    if(root.right!=null)printNodeForLevel( root.right,level-1 );
  }
 public static void levelOrderIter(Node root)
 {
   if(root==null) return;
   Queue<Node> q = new LinkedList();
   q.offer( root );
   while(!q.isEmpty())
   {
     Node temp= q.poll();
     System.out.print(temp.val + " ");
     if(temp.left!=null)q.offer( temp.left );
     if(temp.right!=null)q.offer( temp.right );
   }
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

     //inorder
    System.out.print( "Inorder recurrsive   :- ");
    inOrderRecur( t1 );
    System.out.println();
    System.out.print( "Inorder Iterative    :- ");
    inOrderIter( t1 );
    System.out.println();

    //preorder
    System.out.print( "Preorder recurrsive  :- ");
    preOrderRecur( t1 );
    System.out.println();
    System.out.print( "Preorder Iterative   :- ");
    preOrderIter( t1 );
    System.out.println();

    //postorder
    System.out.print( "Postorder recurrsive :- ");
    postOrderRecur( t1 );
    System.out.println();
    System.out.print( "Postorder Iterative  :- ");
    postOrderIter( t1 );
    System.out.println();

    //Levelorder
    System.out.print( "Levelorder recrrsive :- ");
    levelOrderRecur( t1 );
    System.out.println();
    System.out.print( "Levelorder Iterative :- ");
    levelOrderIter( t1 );
    System.out.println();
  }
}
