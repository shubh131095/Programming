package Strings;

import java.util.HashMap;
import java.util.Map;

// int this program you have given 2 string, you have to find the min size window in string one which contain all the character of String 2
// incomplete
public class MinSizeWindow
{
  public static void main( String[] args )
  {
    String s1 = "Find in this String,it might have more";
    String s2 = "ith";
    findWindow(s1,s2);
  }

  private static void findWindow( String original, String pattern )
  {
    if(original.length()<pattern.length()) return;
    HashMap<Character,Integer> map = new HashMap<>();
    boolean checked = false;
    for(int i=0;i<pattern.length();i++)
    {
      map.put(pattern.charAt(i),0);
    }
    for(int j=0;j<original.length();j++)
    {
        checked = checkMap( map );
        if(checked)
        {

        }
    }
  }
  private static boolean checkMap(HashMap<Character,Integer> map)
  {
    return map.values().stream().allMatch( i -> i >0 ); // it will return false if any value is < 0
  }
}
