package trees;
//in this question you have given a key( node) and a distance K
// you have to print all the nodes which are at K distance from key.
public class KeyKDistanceNode
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
    getKDistNodeFromKey(t1,2,2); // here 2nd parameter is key and 3rd parameter is k
  }

  public static int getKDistNodeFromKey( Node root, int key, int k )
  {
    if(root==null) return 0;
    int ans = 0;
    if(root.val == key)
    {
      PrintNodeKDist.getNodesAtKDistance(root,k);
      return 1;
    }
    else
    {
      if( root.left != null )
      {
        ans = getKDistNodeFromKey( root.left, key, k );
        if(ans==k)
        {
          System.out.print(root.val + " ");
          return 0;
        }
        else if (ans>=1 && ans<=k)
        {
          PrintNodeKDist.getNodesAtKDistance(root.right,k-ans-1);
          return ans+1;
        }
      }

      if( root.right != null )
      {
        ans = getKDistNodeFromKey( root.right, key, k );
        if(ans==k)
        {
          System.out.print(root.val + " ");
          return 0;
        }
        else if (ans>=1 && ans<=k)
        {
          PrintNodeKDist.getNodesAtKDistance(root.left,k-ans-1);
          return ans+1;
        }
      }
    }
    return ans;
  }
}
