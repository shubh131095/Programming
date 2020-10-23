package array;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

//Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
public class MaxSubCircularArraySum
{
  public static void main (String[] args) {

      int[] arr= {2,-4,-5,11,-2,10};

      int max_sum = arr[0];
      int cur_sum=arr[0];
      int min_sum=arr[0];
      int min_curr=arr[0];
      int total = arr[0];
      int j=1;

      for(;j< arr.length;j++)
      {
        cur_sum = max(cur_sum,arr[j]);
        max_sum = max(max_sum,cur_sum);
        min_curr = min(min_curr,arr[j]);
        min_sum = min(min_curr,min_sum);
        total+=arr[j];
      }
      int fin_sum = (max_sum>0)?max(max_sum,total-min_sum):max_sum;
    }
}

