package backtracking;

public class NQueen
{
  public static boolean queenFind(int[][] arr,int row,int column)
  {
    if(row>=column) return true;
    for(int i=0;i<column;i++)
    {
      arr[row][i] = 1;
      if(checkConflict(arr,row,i,column))
      {
        if(queenFind( arr,row+1,column )) return true;
        else
        {
          arr[row][i]=0;
          continue;
        }
      }
      else
        arr[row][i]=0;
    }
    return false;
  }

  private static boolean checkConflict( int[][] arr, int row,int col,int size)
  {
    if(row==0) return true;

    // to check if any queen present in same col
    for(int i=0;i<row;i++)
    {
      if(arr[i][col]==1) return false;
    }
    // to check if any queen present on left upper diagonal
    for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
    {
      if(arr[i][j]==1) return false;
    }
    // to check if any queen present on right upper diagonal
    for(int i=row-1,j=col+1;i>=0&&j<size;i--,j++)
    {
      if(arr[i][j]==1) return false;
    }
    return true;
  }

  public static void main( String[] args )
  {
    int n = 4; // this will be provided
    int arr[][]= new int[n][n];
    queenFind( arr,0,n );
    for(int i=0;i<n;i++)
    {
      for( int j = 0; j < n; j++ )
      {
        System.out.print( arr[i][j] + " " );
      }
      System.out.println();
    }
  }
}
