package array;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArray0Sum
{
  public static void main( String[] args )
  {
    int arr[] = {15,-1,-1, 2, -8, 1, 7, 10, 23};
    int sum = 0;
    int maxLen=0;
    Map<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<arr.length;i++)
    {
      sum = sum+arr[i];
      if(sum==0)
      {
        if(maxLen < i+1 ) maxLen=i+1;
      }
      else if( map.get(sum)!=null)
      {
        if(maxLen < i - map.get(sum) ) maxLen = i- map.get( sum );
      }
      else map.put( sum,i );
    }
    System.out.println(maxLen);
  }
}
