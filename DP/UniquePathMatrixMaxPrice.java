package DP;

import java.util.ArrayList;
import java.util.List;

// same as prev problem only thing every grid/cell has its cost, you have to find max/min( will do max in this que,but genrally min) weighted path.
//one more variation of this que can come,where there are block tiles also, so u have to avoid that. then it will be a combination of this + UniquePathMatrixRed problem.(not doing here)
// in this we can also add path(ans)
public class UniquePathMatrixMaxPrice
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
    int[][] cost = { {1,2,1},{3,2,5},{4,5,2}};
    dpBU = new int[row+1][column+1];
    dpTD = new int[row+1][column+1];
    System.out.println( getPathBUMC(row,column,cost));
    System.out.println( getPathTDMC(row,column,cost));
  }

  private static int getPathBUMC( int row, int column, int[][] cost )
  {
    dpBU[0][0]= cost[0][0];
    List<Integer[]> path = new ArrayList<>();
    path.add( new Integer[]{0, 0} );
    for(int i=0;i<row;i++)
    {
      for(int j=0;j<column;j++)
      {
        // here since we can come to a cell from its left or up cell.
        // to solve for boundaries we need if.
        if(i>0 && j>0)
        {
          dpBU[i][j] = Math.max(dpBU[i - 1][j] , dpBU[i][j - 1]) + cost[i][j];

        }
        else if(i>0)
        {
          dpBU[i][j] = dpBU[i-1][j] + cost[i][j];

        }
        else if(j>0)
        {
          dpBU[i][j] = dpBU[i][j-1]+ cost[i][j];

        }
      }

    }
    // just traverese dp aaray for getting the path, should be easy.
    return dpBU[row-1][column-1];
  }

  private static int getPathTDMC( int row, int column, int[][] cost )
  {
    // if you narrow down you will find,for any combination of i,j(destination) where any one(i,j) is one, you can reach there only by 1 way.
       if(row==1 && column==1)
       {
         return cost[row-1][column-1];
       }
       else if(row<1 || column<1)
       {
          return 0;
       }
    else if(dpTD[row][column]!=0) return dpTD[row][column];
    else
    {
      dpTD[row][column] = Math.max( getPathTDMC( row - 1,column, cost ) , getPathTDMC( row, column - 1, cost )) + cost[row-1][column-1];
    }
    return dpTD[row][column];
  }
}
