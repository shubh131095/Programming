package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// in this problem you have to generate all sub sequence of an given array
public class SubsequenceArray
{
  public static List<Integer> addList( int[] arr, List<List<Integer>> ans, int[] temp)
  {
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<temp.length;i++)
    {
      if(temp[i]!=0)
      {
      list.add( arr[i] );
      }
    }
    return list;
  }
  public static void getSubsequence(int[] arr,List<List<Integer>> ans,int[] temp,int start)
  {
    if(start==arr.length)
    {
      ans.add(addList(arr,ans,temp));
      return;
    }
    temp[start] = 0;
    getSubsequence( arr,ans,temp,start+1 );
    temp[start]=1;
    getSubsequence( arr,ans,temp,start+1 );
  }
  public static void main( String[] args )
  {
    int[] arr = new int[]{1,2,3};
    List<List<Integer>> ans = new ArrayList<>();
    getSubsequence(arr,ans,new int[arr.length],0);
    List<List<Integer>> finalans = ans.stream().sorted( (i,j) ->
    {
      if( i.size()-j.size()==0)
      {
        if( j.get(0) > i.get( 0 ) ) return -1;
        else return 1;
      }
      else
      return  i.size()-j.size();
    }).collect( Collectors.toList());
    for(List<Integer> list : finalans)
    {
      System.out.println(list);
    }
  }
}
