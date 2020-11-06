
// A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any
// connected graph without simple cycles is a tree.
//
//Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates
// that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree
// as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees,
// those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
//
//Return a list of all MHTs' root labels. You can return the answer in any order.
//
//The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

//examples
// 1
// Input: n = 4, edges = [[1,0],[1,2],[1,3]]
//Output: [1]
//Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

//2
// Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//Output: [3,4]

//incomplete

package LeetCode.nov_challenge;

import java.util.HashMap;

public class NOV4_MinHeightTree
{
  public static void main( String[] args )
  {
    int nodes = 6;
    int [][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
    HashMap<Integer,Integer> map = new HashMap<>();
    // storing which nodes has how many edges
    for(int i=0;i< edges.length;i++)
    {
      if(map.containsKey( edges[i][0] ))
      {
        map.put( edges[i][0],map.get(edges[i][0]) +1  );
      }
      else
      {
        map.put( edges[i][0],1 );
      }
      if(map.containsKey( edges[i][1] ))
      {
        map.put( edges[i][1],map.get(edges[i][1]) +1  );
      }
      else
      {
        map.put( edges[i][1],1 );
      }
    }
  }
}
