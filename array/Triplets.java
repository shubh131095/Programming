package array;

import java.util.Arrays;

// Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
public class Triplets
{
  static int serach(int arr[],int i,int j,int num)
  {
    if( i>j) return 0;
    int mid = (i+j)/2;
    if(arr[mid]==num) return 1;
    else if( arr[mid]>num) return serach( arr, i, mid-1, num);
        else return serach( arr, mid+1, j, num);
  }
  static int countTriplet(int arr[], int n) {
    // code here
    int count =0;
    int sum=0;
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++)
    {
      for(int j=arr.length-1;j-1>i;j--)
      {
        int num = arr[j]-arr[i];
        if(!(arr[i] ==num || arr[j]==num))
        {
          sum = serach( arr, i, j, num );
          count += sum;
        }
      }
    }
    return count;
  }

  public static void main( String[] args )
  {
      int[] arr = {12,8, 2 ,11 ,5, 14 ,10};
    System.out.println(countTriplet(arr,arr.length));
  }
}
