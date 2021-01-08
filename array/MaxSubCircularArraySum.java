package array;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

//Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

//Approach
// 1. the max sum can lie in between, we get ans from kadanes
// 2. if ans is not in middle that means its spreaded , half part in left boundary half part in righ boundary.
      // for this you can use reverse kadanes, get min sum of aaray and sub from totalsum of array.
// return max of ans got from 1 and 2.
public class MaxSubCircularArraySum
{
  public static void main (String[] args) {

      int[] arr= {3,-4,-5,11,-2,10};

    int global_max = arr[0];
    int global_min = arr[0];
    int curr_max = arr[0];
    int curr_min = arr[0];
    int sum = arr[0];

    for (int i = 1; i < arr.length; i++) {
      curr_max = Math.max(curr_max + arr[i], arr[i]);
      curr_min = Math.min(curr_min + arr[i], arr[i]);
      global_max = Math.max(global_max, curr_max);
      global_min = Math.min(global_min, curr_min);
      sum += arr[i];
    }

    int ans = global_max > 0 ? Math.max(sum - global_min, global_max) : global_max;
    }
}

