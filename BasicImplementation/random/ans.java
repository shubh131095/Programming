package BasicImplementation.random;

// in this class we have to count all the cells whose row sum and col sum is under the given range(pair of numbers)
// the queries array are the no of test_cases basically . so for all queries[] find the ans.

public class ans
{
  public static void main( String[] args )
  {
    int[][] arr = {
      {1, 2, 3},
      {4, 2, 7},
      {3, 8, 8}
    };
    int[][] queries = {
      {8, 13},
      {3, 7},
      {10, 20},
      {6, 18}
    };
    getAns( arr, queries );
  }

  private static boolean checkIt( int b, int[] qur )
  {
    int low = qur[0];
    int high = qur[1];

    if( b <= Math.max( low, high ) && b >= Math.min( low, high ) )
    {
      return true;
    }
    return false;
  }

  private static void getAns( int[][] arr, int[][] queries )
  {
    int row_sum[] = new int[arr.length];
    int col_sum[] = new int[arr[0].length];
    for( int i = 0; i < arr.length; i++ )
    {
      for( int j = 0; j < arr[i].length; j++ )
      {
        row_sum[i] += arr[i][j];
        col_sum[i] += arr[j][i];
      }
    }
    for( int[] qur : queries )
    {
      int count = 0;
      for( int k = 0; k < arr.length; k++ )
      {
        if( !checkIt( row_sum[k], qur ) )
        {
          continue;
        }
        for( int l = 0; l < arr[k].length; l++ )
        {
          if( checkIt( col_sum[l], qur ) )
          {
            count++;
          }
        }
      }
      System.out.println( count );
    }
  }
}
