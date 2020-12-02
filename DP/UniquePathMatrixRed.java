package DP;
// same problem like UniquePathMatrix1 , with one more constraints given a set of cell which cannot be visited.
public class UniquePathMatrixRed
{
  static int [][] dpBU;
  static int [][] dpTD;
  public static void main( String[] args )
  {
    //1.objective function
    // to reach f(i,j) ->i.e no of ways to reach i,j cell
    //2. find the base case i.e for which u know the ans
    // i.e(f(1) -> 1
    // just write the ans
    int row=3;
    int column = 3;
    int[][] restrict = { {1,1},{0,2}};
    dpBU = new int[row+1][column+1];
    dpTD = new int[row+1][column+1];
    System.out.println( getPathBUR(row,column,restrict));
    System.out.println( getPathTDR(row,column,restrict));
  }
  private static boolean findRestricted( int i, int j, int[][] restict )
  {
    for(int k=0;k< restict.length;k++)
    {
      int temp[] = restict[k];
      if(temp[0]==i && temp[1]==j)
      {
        return true;
      }
    }
    return false;
  }
  private static int getPathBUR( int row, int column, int[][] restict )
  {
    dpBU[0][0]= 1;
    for(int i=0;i<row;i++)
    {
      for(int j=0;j<column;j++)
      {
        // here since we can come to a cell from its left or up cell.
        // to solve for boundaries we need if.
        // one extra cond, if its a restricted cell dont visit.
        if(findRestricted(i,j,restict))
        {
          dpBU[i][j] = 0;
          continue;
        }
        if(i>0 && j>0)
        {
          dpBU[i][j] = dpBU[i - 1][j] + dpBU[i][j - 1];
        }
        else if(i>0)
        {
          dpBU[i][j] = dpBU[i-1][j];
        }
        else if(j>0)
        {
          dpBU[i][j] = dpBU[i][j-1];
        }
      }

    }
    return dpBU[row-1][column-1];
  }

  private static int getPathTDR( int row, int column, int[][] restict )
  {
    // if you narrow down you will find,for any combination of i,j(destination) where any one(i,j) is one, you can reach there only by 1 way.
    if(findRestricted( row-1,column-1,restict ))
    {
      return 0;
    }
    else if(row==1 || column==1)
      return 1;
    else if(dpTD[row][column]!=0) return dpTD[row][column];
    else
    {
      dpTD[row][column] = getPathTDR( row - 1,column, restict ) + getPathTDR( row, column - 1, restict );
    }
    return dpTD[row][column];
  }
}
