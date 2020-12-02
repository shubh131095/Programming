package LeetCode.nov_challenge;
//Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all
// the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above
// is less than or equal to threshold.
//
//Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3
// = 3 and 10/2 = 5).
//
//It is guaranteed that there will be an answer.
//
//
//
//Example 1:
//
//Input: nums = [1,2,5,9], threshold = 6
//Output: 5
//Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
//If the divisor is 4 we can get a sum to 7 (1+1+2+3 which is greater than threshold and if the divisor is 5 the sum will be 5 (1+1+1+2).


public class NOV6_SmallestDivisor
{
  public static void main( String[] args )
  {
    int[] inp={19};
    int threshold=6;
  int ans=  findDivisor(inp,threshold);
    System.out.println(ans);
  }

  private static int findDivisor( int[] inp, int threshold )
  {
    int sum=0;
    int k=1;
    while(true)
    {

      int temp=0;
      sum=0;
      for( int i = inp.length - 1; i >= 0; i-- )
      {
         temp = inp[i] % k;
        if(temp >0) temp=1;
        sum+= inp[i]/k + temp;
        if(sum>threshold) break;
      }
      if(sum<=threshold) return k;
      k++;
    }
  }
}
