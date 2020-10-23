package array;

import java.util.Scanner;

//maximum sum of sub array
public class KadaneAlgo
{
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    while(tc-- >0)
    {
      int size=sc.nextInt();
      int[] arr= new int[size];
      for(int i=0;i<size;i++)
      {
        arr[i]=sc.nextInt();
      }
      int max = arr[0];
      int cur_sum=arr[0];
      int j=1;

      for(;j< arr.length;j++)
      {
        cur_sum = cur_sum + arr[j];
        if(cur_sum<0 || cur_sum<arr[j]) cur_sum=arr[j];
        if( cur_sum > max) max=cur_sum;
      }
      System.out.println(max);
    }
  }
}
