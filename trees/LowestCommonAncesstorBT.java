package trees;

import java.util.ArrayList;

public class LowestCommonAncesstorBT
{
  private static int findAncesstorOpti( Node root, Node node1, Node node2  )
  {
    return 0;
  }


  // will find path of both nodes and then compare till last match.
  private static int findAnccesstor( Node root, Node node1, Node node2 )
  {
    int match=0;
    ArrayList<Integer> node1_path = PathToSpecificNode.findThePath(root,node1);
    ArrayList<Integer> node2_path = PathToSpecificNode.findThePath(root,node2);
    for(int i=0;i<node1_path.size()&&i< node2_path.size();i++)
    {
      if(node1_path.get( i ) == node2_path.get( i ))
      {
        match = node1_path.get( i );
      }
      else
        break;
    }
    return match;

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
int ans = findAnccesstor(t1,t3,t8); // require extra space and time
int ans1 = findAncesstorOpti(t1,t6,t9); // better solution

    System.out.println(ans);
    System.out.println(ans1);
  }


}
