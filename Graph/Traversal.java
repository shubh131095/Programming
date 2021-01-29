package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// in this class we have implemented both the traversal used for graph
// 1. BFS
// 2. DFS
// Similar to tree.
public class Traversal
{
  public static void main( String[] args )
  {
    Graph<Integer> g = new Graph<Integer>();

    g.addEdge(0, 1, false);
    g.addEdge(0, 4, false);
    g.addEdge(4, 0, false);
    g.addEdge(1, 2, false);
    g.addEdge(1, 3, false);
    g.addEdge(1, 4, false);
    g.addEdge(2, 3, false);
    g.addEdge(3, 4, false);
    g.addEdge(10, 4, false);
    doDFS(0,g.node.size(),g);
    System.out.println();
    doBFS(0,g.node.size(),g);
  }
  // in this function just marking the current node as visited and then visiting its neighbour.
  private static void getDFS( int source, Boolean[] visited,Graph<Integer> graph )
  {
    if(visited[source]) return;

    visited[source] = true;
    System.out.print(source);
    for( Integer edge : graph.node.get(source))
    {
      if(!visited[edge])
      {
        System.out.print("->");
        getDFS( edge,visited,graph );
      }
    }
  }

  private static void doDFS( int source,int totalNodes,Graph<Integer> graph )
  {
    Boolean visited[] = new Boolean[totalNodes];
    Arrays.fill( visited,false );
    getDFS(source,visited,graph);
  }

  // just add all the connected node to current node in queue and traverse one by one.
  private static void getBFS( int source, Boolean[] visited, Graph<Integer> graph)
  {

    Queue<Integer> que = new LinkedList<>();
    que.offer( source );
    while(!que.isEmpty())
    {
      int curr_source = que.poll();
      visited[curr_source] = true;
      System.out.print(curr_source + "->");
      for(Integer edge : graph.node.get( curr_source ))
      {
        if(!visited[edge])
        {
          que.offer( edge );
          visited[edge] = true;
        }
      }
    }
  }

  private static void doBFS( int source,int totalNodes,Graph<Integer> graph )
  {
    Boolean visited[] = new Boolean[totalNodes];
    Arrays.fill( visited,false );
    // this function can be replaced here since its not a recurssive.
    getBFS(source,visited,graph);
  }

}
