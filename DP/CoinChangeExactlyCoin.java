package DP;

import java.util.Arrays;

// same problem like coin change with 1 extra constraint
// u have to use exactly K coins.
public class CoinChangeExactlyCoin
{
  static int [][] dp;
  public static void main( String[] args )
  {

    int [] coins = {1,2,3,5};
    int n = 7;
    int k=3;// possble comb -> 331,511,322 (if order is imp o/p -> 9)
    dp = new int[n+1][k+1];
    dp[0][0] =1 ;// for getting 0 amount we have exactly one way, taking all coin 0 times
    System.out.println(getWaysForExactlyKCoin(coins,n,k));

  }

  private static int getWaysForExactlyKCoin( int[] coins, int n ,int k)
  {

    for(int i=0;i<coins.length;i++)
    {
      for( int l = 0; l <=k; l++ )
      {
        for( int j = coins[i]; j <= n; j++ )
        {
          if(l==0)
          {
            dp[j][l]=0;
          }
          else
          {
            dp[j][l] += dp[j-coins[i]][l];
          }
        }
      }
    }
    return dp[n][k];
  }
}
