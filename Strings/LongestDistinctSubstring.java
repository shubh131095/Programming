package Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// given a string find the length of longest substring which has all distinct characters
public class LongestDistinctSubstring
{
  public static void main( String[] args )
  {
    String s="aabbccdd";
    int ans = findSubstring(s);
    System.out.println(ans);
  }

  private static int findSubstring( String s )
  {
    int ans=0;
    int count=0;
    Map<Character,Integer> map = new HashMap<>();
    for(int i=0;i<s.length();i++)
    {
      if( map.containsKey( s.charAt( i ) ) )
      {
        for( Map.Entry<Character,Integer> a : map.entrySet() )
        {
          if(a.getValue()<i) map.remove( a.getKey() );
        }
      }
      map.put( s.charAt( i ), i );
      count = map.size();
      if( count > ans ) ans = count;
    }
    return ans;
  }
}
