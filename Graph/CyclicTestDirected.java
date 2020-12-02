package Graph;

import java.util.Arrays;

// in this class we will find whether the giving directed graph is cyclic or not.
// approach -> we will do dfs on any random node. and if we get any node in the path which is already visted then we can say it contain cycle.
public class CyclicTestDirected
{
  public static void main( String[] args )
  {
    Graph<Integer> g = new Graph<Integer>();

    g.addEdge(0, 1, false);
    g.addEdge(0, 2, false);
    g.addEdge(1, 2, false);
    g.addEdge(3, 4, false);
    g.addEdge(5, 5, false);

    System.out.println(findCycle(g,g.node.size()));
  }

  private static boolean findCycle( Graph<Integer> g , int totalVertices)
  {
    Boolean visited[] = new Boolean[totalVertices];
    Arrays.fill(visited,false);

    for(int vertex : g.node.keySet())
    {
      if(doDFS(vertex,visited,g)) return true;
    }
    return false;
  }

  private static boolean doDFS( int vertex, Boolean[] visited, Graph<Integer> g )
  {
    // if the current vertex has already been visited,that means we have a cycle;
    if(visited[vertex]) return true;
    visited[vertex] = true;
    for(int edges : g.node.get( vertex ))
    {
      if(doDFS( edges,visited,g )) return true;
    }
    visited[vertex] = false;
    return false;
  }
}
