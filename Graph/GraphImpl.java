package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph<T>
{
  Map<T, List<T>> node;

  public Graph()
  {
    node = new HashMap<>();
  }
  // function for adding a new vertex
  public void addNode(T node)
  {
    this.node.put( node,new ArrayList<>() );
    System.out.println("New Node Added Successfully");
  }
  // function for adding a new edge in existing nodes;
  // if the edge is non-Directional then we have to add entry in both the node
  public void addEdge(T source,T destination,boolean isBiDirectional)
  {
    if(!node.containsKey( source ) )
    {
      System.out.println(source+ ": Node doesnt exist creating new Node");
      addNode( source );
    }
    if( !node.containsKey( destination ))
    {
      System.out.println(destination+ ": Node doesnt exist creating new Node");
      addNode( destination );
    }
    node.get( source ).add( destination );
    if(isBiDirectional)
    {
      node.get( destination ).add( source );
    }
  }
  public int getNodeCount()
  {
    return node.size();
  }
  public int getEdgeCount(boolean isBiDirectional)
  {
    int count=0;
    for(T nodes : node.keySet())
    count += node.get( nodes ).size();
    // using java streams
    // int sum = node.values()
    //                .stream()                                   // this will create stream of map values
    //                .map( i -> i.size() )                       // this will convert list<Integer> -> to its size
    //                .reduce( 0,(a,b) -> a+b);                   // this will add size with starting 0;

    // 2nd way usig stream
    //  int sum1 = map.values()
    //                .stream()
    //                .mapToInt( i -> i.size() ) // since we r mapping output to int(or any no we got sum func,otherwise not aviable.
    //                .sum();
    if(isBiDirectional)
    {
      return count/2;
    }
    else return count;
  }
  public boolean hasNode(T nodes)
  {
    if(node.containsKey( nodes ))
    {
      return true;
    }
    else
      return false;
  }
  public boolean hasEdge( T source,T destination)
  {
    if( !node.containsKey( source ) || !node.containsKey( destination ))
    {
      return false;
    }
    if(node.get( source ).contains( destination )) return true;
    else return false;
  }

  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    for(T nodes : node.keySet())
    {
      sb.append( nodes + ":" );

      for(T edges : node.get( nodes ))
      {
          sb.append( edges + "->" );
      }
      sb.append( "\n" );
    }
    return sb.toString();
  }
}
public class GraphImpl
{
  public static void main( String[] args )
  {
    Graph<Integer> g = new Graph<Integer>();

    g.addEdge(0, 1, true);
    g.addEdge(0, 4, true);
    g.addEdge(1, 2, true);
    g.addEdge(1, 3, true);
    g.addEdge(1, 4, true);
    g.addEdge(2, 3, true);
    g.addEdge(3, 4, true);

    // print the graph.
    System.out.println("Graph:\n"
                       + g);

    // gives the no of vertices in the graph.
    System.out.println("Nodes count is :- " + g.getNodeCount());

    // gives the no of edges in the graph.
    System.out.println("Edges count is :- " + g.getEdgeCount(true));

    // tells whether the edge is present or not.
    System.out.println( " Edge between 3 to 4 is present :- " + g.hasEdge(3, 4));

    // tells whether vertex is present or not
    System.out.println("Is node 5 exist:- "+ g.hasNode(5));
  }

}
