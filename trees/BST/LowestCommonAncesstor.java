package trees.BST;

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

// 2 numbers that are present in bst is given give the value of node of their LCA
public class LowestCommonAncesstor
{
  private static int getAncesstorRec(Node root, Node node1, Node node2)
  {
    if(root==null) return 0;
    if( (node1.val<=root.val && node2.val >= root.val) || (node1.val>=root.val && node2.val <= root.val))
    {
      return root.val;
    }
    else if ( node1.val<=root.val && node2.val <= root.val)
    {
      return getAncesstorRec( root.left,node1,node2 );
    }
    else
      return getAncesstorRec( root.right,node1,node2 );
  }

  private static int getAncesstorIter(Node root, Node node1, Node node2)
  {
    if(root==null) return 0;
    while(true)
    {
      if( (node1.val<=root.val && node2.val >= root.val) || (node1.val>=root.val && node2.val <= root.val))
      {
        return root.val;
      }
      else if ( node1.val<=root.val && node2.val <= root.val)
      {
        root = root.left;
      }
      else
        root=root.right;
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

    t7.left=t4;
    t7.right=t10;
    t4.left=t2;
    t4.right=t6;
    t10.left=t9;
    t10.right=t11;
    t2.left=t1;
    t2.right=t3;
    t6.left=t5;
    t9.left=t8;

    int ans = getAncesstorRec(t7,t4,t5);
    int ans1 = getAncesstorIter(t7,t4,t5);
    System.out.println(ans);
    System.out.println(ans1);
  }

}
