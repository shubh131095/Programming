package DP;
// in this problem you will be provided by a set of coins (with values) and you will be given a no n
// you have to find the no of ways you can get n from the given set of coins
// you can use any coin any no of time.

// Approach-1
//n this que we are taking all odering as same ( like 113 and 311 and 131 to make 5 is same and will be counted only 1)
// to count all the above ways as different,just reverse the for loop in the func.
import java.util.Arrays;

public class CoinChange
{
  static int [] dp;
  public static void main( String[] args )
  {

    int [] coins = {1,2,3,5};
    int n = 7; // possble com-> 116,1(*8),3311,31(*5)
    dp = new int[n+1];
    Arrays.fill(dp,0);
    dp[0]=1 ;// for getting 0 amount we have exactly one way, taking all coin 0 times
    System.out.println(getWaysForCoin(coins,n));

  }

  private static int getWaysForCoin( int[] coins, int n )
  {

    for(int i=0;i<coins.length;i++)
    {
      // basic crux of this soln is, wie will update all the index which is greater than n using the coins we have
      // example using 1, we can produce 1->8 all amount.
      // using 3, we can produce 3->8 exactly once like wise.
      for(int j=coins[i];j<=n;j++)
      {
          dp[j] += dp[j-coins[i]];
      }
    }
    return dp[n];
  }
}
