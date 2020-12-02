package trees;
// in this que you have to traverse the tree in level order but in spiral way.
// i.e start from root got left 1 below level got to right then dont come back to left.from current postition(right side go down and come back to left and repeat).

import java.util.Stack;

//approach 1 -> take 2 stacks, in one stack keep all even level nodes and in 1 stack keep all odd level nodes.
// in one stack push nodes from left to right and in one stack push from right to left.
public class LevelSpiralTraversal
{
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

    doSpiralLevelorder(t1);
  }

  private static void doSpiralLevelorder( Node root )
  {
    if(root==null) return;
    Stack<Node> even = new Stack<>();
    Stack<Node> odd = new Stack<>();
    int k=0;
    even.push(root);
    while( !even.isEmpty()  || !odd.isEmpty() )
    {
      if(k%2==0)
      {
        while(!even.isEmpty())
        {
          Node temp = even.pop();
          System.out.print(temp.val + " ");
          if(temp.right!=null) odd.push( temp.right );
          if(temp.left!=null) odd.push( temp.left );
        }
      }
      else
      {
        while(!odd.isEmpty())
        {
          Node temp = odd.pop();
          System.out.print(temp.val + " ");
          if(temp.left!=null) even.push( temp.left );
          if(temp.right!=null) even.push( temp.right );
        }
      }
      k++;
    }

  }
}
