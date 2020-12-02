package DP;
// in this problem we have given a 2d matrix, we haev to find total no of ways from reaching destination from start.
// you can only move forward or down from current cell.
// this que will be done using 2 apprach
  // 1. top-down
  // 2. bottom-up
public class UniquePathMatrix1
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
    dpBU = new int[row+1][column+1];
    dpTD = new int[row+1][column+1];
    System.out.println(getPathBU(row,column));
    System.out.println(getPathTD(row,column));
  }

  private static int getPathBU( int row, int column )
  {
    dpBU[0][0]= 1;
    for(int i=0;i<row;i++)
    {
      for(int j=0;j<column;j++)
      {
        // here since we can come to a cell from its left or up cell.
        // to solve for boundaries we need if.
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

  private static int getPathTD( int row, int column )
  {
    // if you narrow down you will find,for any combination of i,j(destination) where any one(i,j) is one, you can reach there only by 1 way.
    if(row==1 || column==1)
      return 1;
    if(dpTD[row][column]!=0) return dpTD[row][column];
    else
    {
      dpTD[row][column] = getPathTD( row-1,column ) + getPathTD( row,column-1 );
    }
    return dpTD[row][column];
  }
}
