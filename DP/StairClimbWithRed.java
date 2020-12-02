package DP;
// this problem is just like stair climb prob with one extra constarins
// in this we have given a boolean aaray , and all the index which is true means we cannot go to that stair.
// this problem can have 2 variation
// either boolean aaaray will be given or a aaray will be given with red stair index ( where we cannot go)
// in 2nd case we can do 2 things
// 1. in dp aaray mark all red index as -1 and when encounter -1 make it 0.( O(x) -> x is size of red stair aaray )
// 2. when findinf value for f(i) search in array using binary search whether that no is there or not. ( inefficient) ( O( nlogx))

// in this if we can optimise the dp size
// we only need dp of size k;
// so in one iteration we will populate the complete dp aaray, after that we can use mod to start using 0.
public class StairClimbWithRed
{
  static int dpA[];
  static int dpB[];
  static int dpOpti[];
  public static void main( String[] args )
  {
    int n=7;
    boolean [] bool= {false,false,true,true,false,false,false}; // here starting point can never be red so bool[0] = 1st stair
    int redStair[] = {3,4};
    dpB = new int[n+1];
    dpA = new int[n+1];
    int k=3;
    dpOpti = new int[k];
    dpOpti[0] =1;
    dpB[0] =1;
    dpA[0] =1;

    // here we cannot assign any other value than dp[0] as they can be red tile
   /* dp[1] =1;
    dp[2]=2;*/
    System.out.println(countWaysBool(n,k,bool));
    System.out.println(countWaysBArray(n,k,redStair));
    System.out.println(countWaysBoolOpti(n,k,bool));
  }

  private static int countWaysBoolOpti( int n, int k, boolean[] bool )
  {
    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<k;j++)
      {
        if(i-j <0) continue;
        // here if bool[i-1] is true means a red tile that means we cant reach there. i-1 as we explained above
        if(bool[i-1])
        {
          dpOpti[i%k] = 0;
          break;
        }
        else
        {
          dpOpti[i%k] += dpOpti[(i-j)%k];
        }
      }
    }
    return  dpOpti[n%k];
  }

  private static int countWaysBArray( int n, int k, int[] redStair )
  {
    for(int i=0;i< redStair.length;i++)
    {
      dpA[redStair[i]]=-1;
    }
    for(int i=1;i<=n;i++)
    {
      if(dpA[i] == -1)
      {
        dpA[i] = 0;
        continue;
      }
      for(int j=1;j<=k;j++)
      {
        if(i-j <0) continue;
        // here if bool[i-1] is true means a red tile that means we cant reach there. i-1 as we explained above

          dpA[i] += dpA[i-j];
      }
    }
    return  dpA[n];
  }

  private static int countWaysBool( int n, int k, boolean[] bool )
  {
    for(int i=1;i<=n;i++)
    {
      for(int j=1;j<=k;j++)
      {
        if(i-j <0) continue;
         // here if bool[i-1] is true means a red tile that means we cant reach there. i-1 as we explained above
        if(bool[i-1])
        {
          dpB[i] = 0;
          break;
        }
        else
        {
          dpB[i] += dpB[i-j];
        }
      }
    }
    return  dpB[n];
  }
}
