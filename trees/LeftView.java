package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LeftView
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
   /* t2.left=t4;*/
    t2.right=t5;
    t3.left=t6;
    t3.right=t7;
  t5.left=t8;
    t5.right=t9;
    t6.right=t10;
    t7.left=t11;
    Map<Integer, Integer> map = new TreeMap<>();
    findLeftView(t1,map,0);
    for(Map.Entry<Integer,Integer> val : map.entrySet())
    {
      System.out.println(val.getKey() + "->" + val.getValue());
    }


  }

  private static void findLeftView( TreeImpl root,Map<Integer,Integer> map ,int level)
  {
    if(root==null) return;
    if(!map.containsKey( level ))
    {

      map.put( level,root.val);
    }
    if(root.left!=null) findLeftView( root.left,map,level+1 );
    if(root.right!=null) findLeftView( root.right,map,level+1 );
  }

}

