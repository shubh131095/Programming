package Strings;

import java.util.HashMap;
import java.util.Map;

public class Anagrams
{

  // approach 1 :- count on hashmap
  //approach 2 ( effective)
  // use ascii value i.e count all charcters ascii in string 1 and then subtract asci from 2nd, it should be same.
  // if string lenght is diff return before.
  public static boolean isAnagram(String s1,String s2)
  {
    Map<Character,Integer> hmap = new HashMap<>();
    if( s1.length() != s2.length() )
    {
      System.out.println("not anagram"); return false;
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
        hmap.put(s2.charAt(j),hmap.get( s2.charAt(j) )-1);
      }
      else
        return false;
    }
        int fin = (int)hmap.values().stream().filter( i -> i!=0 ).count();
    if(fin>0) return false;
    else return true;
  }
  private static boolean isAnagramByAscii( String s1, String s2 )
  {
    if(s1.length()!=s2.length()) return false;
    int count =0;
    for(int i=0;i<s1.length();i++)
    {
      count += s1.charAt( i ) - s2.charAt( i );
    }
    if(count==0) return true;
    else return false;
  }
  public static void main( String[] args )
  {
    String s1 = "ababaa";
    String s2="abbaaa";
    String s3 = "abbaab";
    System.out.println(isAnagram(s1,s2));
    System.out.println(isAnagram(s3,s2));
    System.out.println(isAnagramByAscii(s1,s2));
    System.out.println(isAnagramByAscii(s3,s2));
  }


}
