package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//in this que youre given n,k,p[]
// n -> no of steps
// k -> no of jumps allowed
// p [] -> aaray containig price for each stairs (p[0] will contain price of 1st stair
// op -> provide the path to destination with min cost.
public class StairClimbWithPrice
{
  static int[] dp ;
  private static void findMinPath( int n, int k, int[] price, int[] ans )
  {
      dp[0] = 1;
      ans[0]=0;
      List<Integer> list = new ArrayList<>();
      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=k;j++)
        {
          if(i-j <0) break;
          if(dp[i]==0)
          {
            dp[i] = dp[i-j]+price[i-1];
            ans[i] = i-j;
          }
          else
          {
            if(dp[i]>dp[i-j]+price[i-1])
            {
              dp[i] = Math.min( dp[i], dp[i - j] + price[i-1] );
              ans[i] = i-j;
            }
          }
        }
      }
      list.add( n );
      for(int i=ans.length-1;i>=1;)
      {
        list.add( ans[i] );
        i = ans[i];
      }
    Collections.reverse( list );
    System.out.println(list);
  }

  public static void main( String[] args )
  {

    int n = 8;
    dp = new int[n+1];
    int k = 2;
    int price[] = {2,1,3,5,2,3,6,4};
    int[] ans= new int[n+1];
    findMinPath(n,k,price,ans);
  }


}
