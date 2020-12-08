package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class WeigtedGraph<T>
{
  Map<T, List<Edges>> nodes;

  public WeigtedGraph()
  {
    nodes = new HashMap<>();
  }
  public void addVertex( T vertex)
  {
    if(nodes.containsKey( vertex ))
    {
      System.out.println("Vertex already preseent");
    }
    else
    {
      nodes.put( vertex,new LinkedList<Edges>() );
    }
  }
  public void addEdge(T source,T destination,int weight , Boolean isBiDirectional)
  {
    Edges edge = new Edges( weight,source,destination );
    if(!nodes.containsKey( source ))  addVertex( source );
    if (!nodes.containsKey( destination )) addVertex( destination );

    nodes.get( source ).add(edge);
    if(isBiDirectional)
    {
      Edges reverseEdge = new Edges( weight,destination,source );
      nodes.get( destination ).add( reverseEdge );
    }
  }
  public boolean hasVertex( T vertex)
  {
    if(nodes.containsKey( vertex )) return true;
    else return false;
  }

  public boolean hasEdge(T source,T destination)
  {
    List<Edges> currentEdges= nodes.get( source );

    for(Edges a : currentEdges )
    {
      if(a.getDestination().equals( destination ))
      {
        return true;
      }
    }
    return false;

//    using streams
//    int edgeCount=
//      (int) nodes.get( source ).stream()
//                                .filter( ( i) -> i.getDestination().equals( destination ) )
//                                .count();
  }

}

public class WeightedGraphImpl
{
  public static void main( String[] args )
  {
    WeigtedGraph<Integer> graph = new WeigtedGraph<Integer>();
    graph.addEdge(0, 1, 1,true);
    graph.addEdge(0, 2,2,true );
    graph.addEdge(1, 2, 3,true);
    graph.addEdge(1, 4, 2,true);
    graph.addEdge(2, 3, 2,true);
    graph.addEdge(4, 3, 4,true);
    graph.addEdge(4, 5, 5,true);
    graph.addEdge(3, 5, 4,true);
  }
}
