package array;

import java.util.Scanner;

// Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...

//approach
// 1 .since its sorted, we need last element in 0 index and then 2nd last in 2 index soo,on
// what we can do is keep iterate over aaray with increment size as 2, and perform one right shift operation from current index to last index.

// 2. easiest
// take a new aaray, fill the new aaray using giving aaray by iterating it from back and front at the same time.
// need extra space.
public class AlternateHighLow
{
  public static void rightShift( int[] arr, int start )
  {
    int temp = arr[start];
    for( int i = start + 1; i < arr.length; i++ )
    {
      int temp2 = arr[i];
      arr[i] = temp;
      temp = temp2;
    }
    arr[start] = temp;
  }

  public static void rearrange(int arr[], int n)
  {
    // initialize index of first minimum and first
    // maximum element
    int max_ele = arr[n - 1];
    int min_ele = arr[0];
    // traverse array elements
    for (int i = 0; i < n; i++) {
      // at even index : we have to put maximum element
      if (i % 2 == 0) {
        arr[i] = max_ele;
        max_ele -= 1;
      }

      // at odd index : we have to put minimum element
      else {
        arr[i] = min_ele;
        min_ele += 1;
      }
    }
  }

  public static void main( String[] args )
  {
    //code

    Scanner sc = new Scanner( System.in );
    int tc = sc.nextInt();
    while( tc-- > 0 )
    {
      int size = sc.nextInt();
      int[] arr = new int[size];
      for( int i = 0; i < size; i++ )
      {
        arr[i] = sc.nextInt();
      }
     /* int j = size - 1;
      for( int i = 0; i < size; i += 2 )
      {
        rightShift( arr, i );
      }*/
      rearrange( arr,size );
      for( int i = 0; i < size; i++ )
      System.out.print(arr[i] + " ");
    }
  }
}