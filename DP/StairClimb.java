package DP;
// you have given the n -> the total no of stairs
// o/p no of ways to reach that step;
// constraints -> you can do 1 or 2 jumps at a time from current step.
 // example if n=3
// op -> 3 ( 1-1-1) (1-2) (2-1)

// one varitation of this problem can come like you will be given k with n , here k represent how many jumps you can do from a current steps.
public class StairClimb
{
  //1.objective function
  // to reach f(n) -> f(n-1) , f(n-2). i.e you can reach nth stair from stair n-1or n-2.
  //2. find the base case i.e for which u know the ans
  // i.e(f(1) -> 1 f(2)-> 2.
  // just write the ans
  static int[] dp = new int[100];
  public static int countWaysTB(int n)
  {
    if(n==1) return 1;
    if(n==2) return 2;
    if(dp[n]!=0) return dp[n];
   else dp[n] = countWaysTB(n-1) + countWaysTB(n-2);
   return dp[n];
  }
  private static int countWaysBU( int n )
  {
    // here we will not use dp aarray as we can optimise that
    int a = 1; // steps require by n-1 steps let say dp(1)
    int b = 2; // steps require by n-2 steps let say dp(2)
    int ans =0;
    for(int i=3;i<=n;i++)
    {
      ans = a + b;
      a = b;
      b = ans;
    }
    return ans;
  }
  private static int countWaysWithK( int n, int k )
  {
   // int a = 1; // steps require by n-1 steps let say dp(1)
    //int b = 2; // steps require by n-2 steps let say dp(2)

    for(int i=3;i<=n;i++)
    {
      // here for one steps we can do n-1.n-2,n-3 ...... n-k steps.
      for(int j=1;j<=k;j++)
      {
        if(i-j < 0) continue;
        dp[i] += dp[i-j];
      }
    }
    return dp[n];
  }
  public static void main( String[] args )
  {
    // this problem can be solve in 2 ways -> top/down or bottom up
    // 1. botttom up recurssion
    // 2. top down is for loop
    int n=5;// not of stairs given;
    dp = new int[n+1];
    dp[0] =1;
    dp[1] =1;
    dp[2]=2;
    int k=2;
  /*  System.out.println(countWaysTB( n ));
    System.out.println(countWaysBU(n));*/
    System.out.println(countWaysWithK(3,3)); // this can again solve in both the above ways
  }
}
