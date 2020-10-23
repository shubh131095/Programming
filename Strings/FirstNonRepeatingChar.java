package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingChar
{
  public static void main( String[] args )
  {
    String s ="abcbcdeedd";
    findNonRepeatingChar(s);
  }

  private static void findNonRepeatingChar( String s )
  {
    // Charcter with its Index and count
    Character ch = null;
    int max= Integer.MAX_VALUE;
    Map<Character,HashMap<Integer,Integer>> map = new HashMap<>();
    for(int i=0;i<s.length();i++)
    {
      if(!map.containsKey( s.charAt( i ) ))
      {
        HashMap<Integer,Integer> innerMap = new HashMap<>();
        innerMap.put(i,1);
        map.put( s.charAt( i ), innerMap );
      }
      else
      {
        HashMap<Integer,Integer> innerMap = map.get( s.charAt( i ) );
       Set<Integer> keys = innerMap.keySet();
        int current_key=0;
       for(Integer a : keys)
       {
          current_key = a;
       }
       int value = innerMap.get( current_key);
       innerMap.clear();
       innerMap.put( current_key,value+1 );
      }
    }
    for(Map.Entry<Character,HashMap<Integer,Integer>> a : map.entrySet())
    {
      HashMap<Integer,Integer> innerMap = a.getValue();
      Set<Integer> keys = innerMap.keySet();
      int current_key=0;
      for(Integer b : keys)
      {
        current_key = b;
      }
      int value = innerMap.get( current_key);
      if( value < 2)
      {
        if(current_key < max)
        {
          max = current_key;
          ch = a.getKey();
        }
      }
    }
    System.out.println("Character is :- " + ch);
  }
}
