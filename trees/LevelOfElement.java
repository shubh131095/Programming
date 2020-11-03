package trees;
// given a element find the level, take root as level 0;
public class LevelOfElement
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
    int ans = getLevel(t1,10,0);
    System.out.println(ans);
  }

  private static int getLevel( Node root, int ele, int level )
  {
    int temp=-1;
    if(root.val==ele) return level;
    if(root.left!=null)
    {
       temp = getLevel( root.left,ele,level+1 );
       if(temp!=-1) return temp;
    }
    if(root.right!=null )
    {
      return getLevel( root.right,ele,level+1 );
    }
    return -1;
  }
}
