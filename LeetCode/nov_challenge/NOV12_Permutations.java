package LeetCode.nov_challenge;
// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any
// order.
//
//Example 1:
//Input: nums = [1,1,2]
//Output: [[1,1,2], [1,2,1], [2,1,1]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Example 2:
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
public class NOV12_Permutations
{
  public static void main( String[] args )
  {
    int[] arr = {1, 1, 3};

    // 1st null is temp list which will hold number temp , last null is the final list of list which will contain all the permutations.
    List<List<Integer>> ans = new ArrayList<>();
    getPermutation( arr, 0,ans );
    for( List<Integer> a : ans )
    { System.out.println(a); }
  }
  private static void swap(int[] arr,int i , int cid)
  {
    int temp = arr[i];
    arr[i] = arr[cid];
    arr[cid] = temp;
  }
  private static void getPermutation( int[] arr, int cid,List<List<Integer>> ans )
  {

    if( cid == arr.length - 1 )
    {
      List temp = new ArrayList();
      for( int a : arr ) temp.add( a );
      ans.add( temp );
      return;
    }
    else
    {
      for( int i = cid; i < arr.length; i++ )
      {
        if( arr[i] != arr[cid] || i==cid)
        {
          swap( arr, i, cid );
          getPermutation( arr, cid + 1, ans );
          swap( arr, i, cid );
        }
      }
    }
  }
}
