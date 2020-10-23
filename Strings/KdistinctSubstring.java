package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import java.util.Map;
import java.util.Set;

public class KdistinctSubstring
{
  public static boolean compareSubString(String s)
  {
    boolean ans=true;
    int [] arr= new int[26];
    for(int i=0;i<s.length();i++)
    {
     if(arr[s.charAt( i )-'a']==0)
     {
       arr[s.charAt( i )-'a']=1;
     }
     else return false;
    }
    return ans;
  }
  public static List<String> subStringsKDist( String inputStr, int num)
  {
   List<String> answer = new ArrayList<>();
   if(inputStr.length()<num) return answer;
    boolean isValid = false;
    Map<Character,Integer> map = new HashMap<>();
    int [] arr = new int[26];
   for (int i=0,j=num-1;j<inputStr.length();)
   {
      isValid = compareSubString(inputStr.substring( i,j+1 ));
     if(isValid)
     {
      answer.add(inputStr.substring( i,j+1 )) ;
     }
     i++;j++;
     }
   return answer;
  }

  public static void main( String[] args )
  {
    String inputStr = "geeksforgeeks";
    int num = 4;
    List<String> list = subStringsKDist(inputStr,num);
    for( String str : list )
    { System.out.print(str + " "); }
  }



}
