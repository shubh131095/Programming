package trees.n_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

// you have a n array tree, each node can have n children.
// you will be given a water level.
// every node value reprent the stickness level(time to get through)
// you have given intial water level,find the total time taken to get water in all leaves.
// water is equally divided on all children.

class Node
{
  int data;
  List<Node> children;

  public Node( int data_ )
  {
    data = data_;
  }
}
public class WaterLeaves
{
  public static void main( String[] args )
  {

    int water_intial = 3;
    Node root = new Node(2);
    Node lev11 = new Node(3);
    Node lev12 = new Node(5);
    Node lev13 = new Node(4);
    Node lev21 = new Node(8);
    Node lev22 = new Node(1);
    Node lev23 = new Node(3);
    Node lev24 = new Node(4);
    Node lev25 = new Node(2);
    Node lev26 = new Node(6);
    List<Node> rootChildren = new ArrayList<>( Arrays.asList( lev11,lev12,lev13 ) );
    root.children = rootChildren;
    List<Node> levl11Children = new ArrayList<>( Arrays.asList( lev21,lev22 ) );
    lev11.children = levl11Children;
    List<Node> levl12Children = new ArrayList<>( Arrays.asList( lev23,lev24) );
    lev12.children = levl12Children;
    List<Node> levl13Children = new ArrayList<>( Arrays.asList( lev25,lev26 ) );
    lev13.children = levl13Children;
    System.out.println(getMaxTimeForLeaveToGetWet(root,water_intial));
  }

  private static int getMaxTimeForLeaveToGetWet( Node root, int water_intial )
  {
    if(root==null) return 0;
    List<Node> curr_children = root.children;
    if(root.children==null) return root.data;
    int curr_max=0;
    int max=0;
    for(Node n : curr_children)
    {
      curr_max = getMaxTimeForLeaveToGetWet( n,water_intial );
      max = Math.max(curr_max,max);
    }
    return max+root.data;
  }
}
