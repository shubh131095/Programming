package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinDeletionForAnagram
{
  public static int makeAnagram(String a, String b) {
    /*int ans =0;
    HashMap<Character, List<Integer>> map = new HashMap<>();
    for(int i=0;i<a.length();i++)
    {
      if(!map.containsKey(a.charAt(i)))
      {
        List<Integer> temp = new ArrayList<>();
          temp.add( 1 );
          temp.add(1);
        map.put(a.charAt(i),temp);
      }
      else
      {
        List<Integer> temp = map.get( a.charAt( i ) );
        int value = temp.remove( 1 );
        temp.add( value );
        map.put(a.charAt(i),temp);
      }
    }
    for(int i=0;i<b.length();i++)
    {
      if(!map.containsKey(b.charAt(i)))
      {
        List<Integer> temp = new ArrayList<>();
        temp.add( 2 );
        map.put(b.charAt(i),1);
      }
      else
      {
        if(map.get(b.charAt(i))==0)
        {
          map.put(b.charAt(i),1);
        }
        else
        {
          map.put(b.charAt(i),map.get(b.charAt(i))-1);
        }
      }
    }
    for(int x : map.values())
    {
      ans += x;
    }
    return ans;*/
    int ans =0;
    int[] map = new int[26];
    for(int i=0;i<a.length();i++)
    {
      map[a.charAt( i ) - 'a']++;
    }
    for(int i=0;i<b.length();i++)
    {
      map[b.charAt( i ) - 'a']--;
    }
    for(int x : map)
    {
      ans += Math.abs( x );
    }
    return ans;
  }

  public static void main( String[] args )
  {

    String s1 ="fcrxzwscanmligyxyvym";
    String s2="jxwtrhvujlmrpdoqbisbwhmgpmeoke";
    int ans= makeAnagram( s1,s2 );
    System.out.println(ans);
  }

}
