package Strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostFrequentWords
{

  public static void main( String[] args )
  {
    String s =
      "the guy went on the to become a legend the whose once the considered to be a failure what a great guy heads off to that guy";
    String[] stopWord = {"a", "to", "on", "be", "the"};
    findMostFreqWords( s, stopWord );
    Comparable c = new Comparable()
    {
      @Override
      public int compareTo( Object o_ )
      {
        return 0;
      }
    };
    Comparator c1 = new Comparator()
    {
      @Override
      public int compare( Object o_, Object t_1 )
      {
        return 0;
      }
    };
  }
  private static void findMostFreqWords( String s, String[] stopWord )
  {
    String [] input = s.split( " " );
    List<String> ans = new ArrayList<>();

    int max=0;
    int cur=0;
    Map<String,Integer> map = new HashMap<>();
    Map<String,Integer> inputMap = new HashMap<>();
    for(String a : stopWord)
    {
      map.put( a,1 );
    }
    for(String b : input)
    {
      if(!map.containsKey( b ))
      {
        if( inputMap.containsKey( b ) )
        {
          cur= inputMap.get( b ) + 1;
          inputMap.put( b,cur );
        }
        else
        {
          inputMap.put( b, 1 );
          cur=1;
        }
      }
      if(cur>max) { max = cur;}
    }

   for( Map.Entry<String,Integer> a : inputMap.entrySet())
   {
       if(a.getValue()==max)
       {
         ans.add( a.getKey() );
       }
   }
    System.out.println(ans + " times" + max);
  }
}
