package DP.TakeOrNot;

import java.util.Arrays;

// In this problem we will deal with 0-1 KnapSack problem with bottom-down approach with and without memoization.
// ans top-down approach

// the key is to write the recusrive soln from that you can easily convert it into top-down;
public class KnapSack
{
  static int dp[][];
  static{
    dp = new int[100][100]; // you can put this using constarint given(W and size), otherwise take large value.
    for( int[] rows :dp)
    {
      Arrays.fill(rows,-1);
    }
  }
  public static void main( String[] args )
  {
   int weight[] = {1,2,3,4,5};
   int price[] = {2,4,2,6,4};
   int W = 8;
   int size = weight.length;
   int ans1 = getMaxProfitWOM(weight,price,W,size);
    System.out.println(ans1);
    int ans2 = getMaxProfitWM(weight,price,W,size);
    System.out.println(ans2);
    int ans3 = getMaxProfitTD(weight,price,W,size);
    System.out.println(ans3);
  }

  private static int getMaxProfitTD( int[] weight, int[] price, int w, int size )
  {
    // intilize the dp aaray ( just convert the base condition)
    // here the dp aaray will look same as for memoisation aaray for bootom-up
    for(int i=0;i<w+1;i++)
    {
      for(int j=0;j<size+1;j++)
      {
        // we had the contion(for bottom up) that n or w if 0 then 0, apply same here
        if( i==0 || j==0)
        {
          dp[i][j]=0;
        }
      }
    }
    // convert the if statement of BU in iereative
    // here i repersent weight of sack and j represent avilable items
    for( int i=1;i<w+1;i++)
    {
      for( int j=1;j<size+1;j++)
      {
        if( i >= weight[j-1])
        {
          dp[i][j] = Math.max( price[j-1]+dp[i-weight[j-1]][j-1],dp[i][j-1]);
        }
        else
        {
          dp[i][j] = dp[i][j-1];
        }
      }
    }
    return dp[w][size];
  }

  // this fnct is exactly same as previous ony adding dp support
  private static int getMaxProfitWM( int[] weight, int[] price, int w, int size)
  {
    if( size==0 || w==0) return 0;

    if( dp[w][size]!=-1) return dp[w][size];
    // lets iterate from back, you can also do from start.

    if( w >=weight[size-1]) // if left weight is >= current item weight then only we can take it
    {
      return dp[w][size]=Math.max( getMaxProfitWOM( weight,price,w-weight[size-1],size-1 ) + price[size-1], getMaxProfitWOM( weight,price,w,size-1 ));
    }
    else
    {
      return dp[w][size]=getMaxProfitWOM( weight,price,w,size-1 ); // if current item weight is greater than left wieght we have to ignore
    }
  }

  // here we are taking size one ahead to skip for 0
  // in simple terms if u keep size as current processing item index,then base contion should also be changed corresondingly.
  private static int getMaxProfitWOM( int[] weight, int[] price, int w, int size)
  {
    // base case, think of it.
    if( size==0 || w==0) return 0;

    // lets iterate from back, you can also do from start.

    if( w >=weight[size-1]) // if left weight is >= current item weight then only we can take it
    {
      return Math.max( getMaxProfitWOM( weight,price,w-weight[size-1],size-1 ) + price[size-1], getMaxProfitWOM( weight,price,w,size-1 ));
    }
    else
    {
      return getMaxProfitWOM( weight,price,w,size-1 ); // if current item weight is greater than left wieght we have to ignore
    }
  }
}
