package Strings;

import java.util.HashMap;
import java.util.Map;

public class Anagrams
{
  // approach 1 :- count on hashmap
  public static void isAnagram(String s1,String s2)
  {
    HashMap<Character,Integer> hmap = new HashMap<>();
    if( s1.length() != s2.length() )
    {
      System.out.println("not anagram"); return;
    }
    for(int i=0;i<s1.length();i++)
    {
      if(hmap.containsKey(s1.charAt(i)))
      {
        hmap.put(s1.charAt(i),hmap.get( s1.charAt(i) )+1 );
      }
      else
        hmap.put( s1.charAt( i ),1 );
    }
    for(int j=0;j<s2.length();j++)
    {
      if(hmap.containsKey(s2.charAt(j)))
      {
        hmap.put(s2.charAt(j),hmap.get( s2.charAt(j) )+1 );
      }
      else
        hmap.put( s1.charAt( j ),1 );
    }


  }
  public static void main( String[] args )
  {
    String s1 = "ababaa";
    String s2="abbaaa";
    String s3 = "abbaab";
    isAnagram(s1,s2);
  }
}
