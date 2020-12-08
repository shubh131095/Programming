package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// this class is implementing topological sorting
// topological sorting is ordering of vertices such that for any 2 verteice in this order the vertex which come after cannot have back edge on before node.
// it work only for directed and acyclic graph
 // fr example :- if there are 3 nodes a b c, where a is connected to b and b is connected to c, then the topo order can be:= abc
// a grapgh can have more than 1 topological order.
public class TopologicalSorting
{
  public static void main( String[] args )
  {
    Graph<Integer> g = new Graph<Integer>();

    g.addEdge(0, 1, false);
    g.addEdge(2, 1, false);
    g.addEdge(3, 0, false);
    g.addEdge(2, 4, false);
    g.addEdge(3, 4, false);
    // we will store topological order in this
    List<Integer> order = new ArrayList<>();
    getTopologicalOrder(g,order);
    // we will get all the nodes added in list from bottom-up i.e why required reverse.
     Collections.reverse( order );
    System.out.println( order );
  }
  private static void doTopologicalSort( Graph<Integer> g, List<Integer> order, Set<Integer> visited, Integer vertex )
  {
    if(visited.contains( vertex )) return ;

    visited.add( vertex );
    // navigate all neigbour and when there are no neighbour add that in order.
    for(Integer edges : g.node.get( vertex ))
    {
      if(visited.contains( edges )) continue;
      else doTopologicalSort( g,order,visited,edges );
    }
    order.add( vertex );
  }
  private static void getTopologicalOrder( Graph<Integer> g, List<Integer> order)
  {
    // create one set for all visited node ( can be a boolean array also)
    Set<Integer> visited = new HashSet<>();

    // for all vertex find the neigbours
    for(Integer vertex : g.node.keySet())
    {
      if(visited.contains( vertex ))
      {
        continue;
      }
      else
      {
        doTopologicalSort(g,order,visited,vertex);
      }
    }

  }

}
