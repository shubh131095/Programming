package Graph;

import java.util.Arrays;

// in this class we will find whether the giving un-directed graph is cyclic or not.
// approach -> we will do dfs on any random node. and if we get any node in the path which is already visted then we can say it contain cycle.we have to also check whther the parent node is not visited twice and returing ccyle.
public class CyclicTestUnDirected
{
  public static void main( String[] args )
  {
    Graph<Integer> g = new Graph<Integer>();

    g.addEdge(0, 1, true);
    g.addEdge(1, 2, true);
    g.addEdge(2, 3, true);
    g.addEdge(2, 4, true);
    g.addEdge(3, 5, true);
    g.addEdge(4, 5, true);

    System.out.println(findCycle(g,g.node.size()));
  }

  private static boolean findCycle( Graph<Integer> g , int totalVertices)
  {
    Boolean visited[] = new Boolean[totalVertices];
    Arrays.fill(visited,false);

    for(int vertex : g.node.keySet())
    {
      // for any node which will act as start node, the parent will be -1
      if(doDFS(vertex,visited,g,-1)) return true;
    }
    return false;
  }

  private static boolean doDFS( int vertex, Boolean[] visited, Graph<Integer> g,int parent )
  {
    // if the current vertex has already been visited,that means we have a cycle;
    if(visited[vertex]) return true;
    visited[vertex] = true;
    for(int edges : g.node.get( vertex ))
    {
      if(edges==parent)
      {
        continue;
      }
      if(doDFS( edges,visited,g,vertex )) return true;
    }
    visited[vertex] = false;
    return false;
  }
}

