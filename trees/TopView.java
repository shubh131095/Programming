
// Print the top view of a binary tree
// Approach
// Just find nodes in every horizontal range and print the first node.
// keep track of ranges that are actually visited.
package trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopView
{
  public static void main( String[] args )
  {
    TreeImpl t1 = new TreeImpl(1);
    TreeImpl t2 = new TreeImpl(2);
    TreeImpl t3 = new TreeImpl(3);
    TreeImpl t4 = new TreeImpl(4);
    TreeImpl t5 = new TreeImpl(5);
    TreeImpl t6 = new TreeImpl(6);
    TreeImpl t7 = new TreeImpl(7);
    TreeImpl t8 = new TreeImpl(8);
    TreeImpl t9 = new TreeImpl(9);
    TreeImpl t10 = new TreeImpl(10);
    TreeImpl t11 = new TreeImpl(11);

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
    Map<Integer, List<Integer>> map = new TreeMap<>();
    findTopView(t1,map,0,0);
    for(Map.Entry<Integer,List<Integer>> val : map.entrySet())
    {
      System.out.println(val.getKey() + "->" + val.getValue().get( 1 ));
    }


  }

  private static void findTopView( TreeImpl root,Map<Integer,List<Integer>> map , int range,int level)
  {
    if(root==null) return;
    if(!map.containsKey( range ))
    {
      List<Integer> newList = new ArrayList<>();
      newList.add(level);
      newList.add(root.val);
      map.put( range,newList);
    }
    else
    {
      List<Integer> newList = map.get( range );
      if( newList.get(0) > level )
      {
        newList.clear();
        newList.add(level);
        newList.add(root.val);
        map.put( range,newList );
      }
    }
    if(root.left!=null) findTopView( root.left,map,range-1,level+1 );
    if(root.right!=null) findTopView( root.right,map,range+1,level+1 );
  }

}
