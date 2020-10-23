package Strings;

import java.util.HashMap;
import java.util.Map;

// There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.
public class WordsSerach
{
  static int[] matchingStrings(String[] strings, String[] queries) {

    Map<String,Integer> hmap = new HashMap<>();
    int size = queries.length;
    int[] arr = new int[size];
    int k=0;
    for(String s : strings)
    {
      if(hmap.containsKey(s))
      {
        int current_value = hmap.get(s);
        hmap.put(s,current_value+1);
      }
      else
      {
        hmap.put(s,1);
      }
    }
    for(String s : queries)
    {
      if(hmap.containsKey(s))
      {
        arr[k++]=hmap.get(s);
      }
      else
        arr[k++]=0;
    }
    return arr;
  }
  public static void main( String[] args )
  {
    String[] s= {"ab","abc","ab"};
    String[] q = {"ab","bc","abc"};
    int [] arr = matchingStrings(s,q);
    for(int i=0;i< arr.length;i++)
    {
      System.out.print(arr[i] + " ");
    }
  }
}
