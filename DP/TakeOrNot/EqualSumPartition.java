package DP.TakeOrNot;
// in this problem you have to tell wehther u can divide the given array into 2 equal subset.
// now there can be many variation also
  // 1. give 2 subest can be of diffrent size and need not include whole aaray but sum should be same.
  //2. give count of total subset with equal sum
  //3. give all the subest with equal sum
  // 4. tell whether the whole aaray can be converted into 2 equal sum ( we will solve this here)
  // all other variation can be dealt later

import java.util.Arrays;

// appporach is very simple
// if the total aaray sum is odd we cannot divide it into 2 equal sum partion
// if sum is even, we just have to find one subset with sum = sum/2. if its there return true else false;
public class EqualSumPartition
{
  public static void main( String[] args )
  {
    int arr[] = {10,8};
    System.out.println(isEqualPartionted(arr,arr.length));
  }

  private static boolean isEqualPartionted( int[] arr, int length )
  {
    int sum = Arrays.stream(arr).sum();
    if( sum%2==0)
    {
      return SubsetSumProblem.getSubsetSumWM(arr,sum/2,length);

    }
    else
    {
      return false;
    }
  }
}
