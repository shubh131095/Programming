package DP.TakeOrNot;
// this problem is a variation of knap sack problem only.
// in this you are given an aaray and a sum value, you have to find
  // varation 1.:- whether any subset present in the araay with given sum -> done
  // variation 2:- give the subset with given sum
  // variation 3 :- given the min/max length subset of the given sum.
  // variation 4:- no of subset with sum value;

// we are solving variation 1 now, in future we will cover all
public class SubsetSumProblem
{
  public static Boolean dp[][];
  static
  {
    dp = new Boolean[100][100]; // size is based on constraints
  }
  public static void main( String[] args )
  {
    int arr[] = {1,2,3,5,7,10,6,8,13};
    int sum = 5; // is present and can be formed using -. {2,3,5} ,{10},{8,2},{6,4},{7,3},{6,3,1},{4,5,1} etc

    // always try to write recusive soln first and then convert into memoization and the top-down.
    System.out.println(getSubsetSum(arr,sum,arr.length));

    // lets add memoization in this recusrive apporach
    // how ro think of dp aaray
    // sum is changing :- it becomes one component
    // size of aaray is changing ( conisdering or not type) :- it becomes one compoennt.
    System.out.println(getSubsetSumWM(arr,sum,arr.length));

    // lets do the TD apporach also
    System.out.println(getSubsetSumTD(arr,sum,arr.length));
  }

  public static boolean getSubsetSumTD( int[] arr, int sum, int size )
  {
    // intilize the dp aaray -> converting base cases
    for( int i=0;i<size+1;i++)
    {
      for( int j=0;j<sum+1;j++)
      {
        if( j==0) // i.e if sum ==0
        {
          dp[i][j] = true;
          continue;
        }
        if(i==0) // if sum is non zero but size is zero
          dp[i][j] = false;
      }
    }
// point to be caustious about
    // loop start from 1 and go till n+1.
    for( int i=1;i<size+1;i++)
    {
      for( int j=1;j<sum+1;j++)
      {
        if( j>= arr[i-1])
        {
          dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
        }
        else
        {
          dp[i][j] = dp[i-1][j];
        }
      }
      }
    return dp[size][sum];
  }

  public static boolean getSubsetSumWM( int[] arr, int sum, int size)
  {
    // base contion remain same
    if( sum==0) return true;
    if( size==0) return false;
    if(dp[sum][size]!=null) return dp[sum][size];
    if( sum>=arr[size-1])
    {
      // we have written the kanp sack soln as it is. just we dont need value array anymore.
      return dp[sum][size]=getSubsetSum( arr,sum-arr[size-1],size-1 ) || getSubsetSum( arr,sum,size-1 );
    }
    else
    {
      return dp[sum][size]=getSubsetSum( arr,sum,size-1 );
    }
  }

  public static Boolean getSubsetSum( int[] arr, int sum, int size )
  {
    // base case;
    // think of it
    if( sum==0) return true;
    if( size==0) return false;

    // if current sum needed value is greater current arr index value, we can either take it or leave it
    // otherwise we have to leave it;
    if( sum>=arr[size-1])
    {
      // we have written the kanp sack soln as it is. just we dont need value array anymore.
      return getSubsetSum( arr,sum-arr[size-1],size-1 ) || getSubsetSum( arr,sum,size-1 );
    }
    else
    {
      return getSubsetSum( arr,sum,size-1 );
    }
  }
}
