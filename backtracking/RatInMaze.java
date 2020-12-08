package backtracking;

import java.util.ArrayList;
import java.util.List;

// in this problem you have given a matrix of size n*m ( generally square) with each cell value as 0 or 1;
// you have to start from a node ( genrally (0,0)) and reach the destination cell ( genrally last cell).
// you cannot go to cell with 0 value
// you can only go down or forward.
// variations
// give the path if exist
// give the min/max path if 1 is replaced with cost.
// here we will deal with if destination cell can be reached.
// min/max cost was already handled in dp UniquePathMatrixPrice.
public class RatInMaze
{
  public static void main( String[] args )
  {
    int [][] maze = {
                        {1,1,0,1},
                        {0,1,1,1},
                        {1,0,1,1},
                        {1,1,1,1}
                    } ;
    int source[] ={0,0}; // just declaring will not use in this
    int dest[]  = {3,3}; // same
    int row = maze.length;
    int col = maze[0].length;
    List<Integer[]> path = new ArrayList<>();
    System.out.println( findPath(maze,0,0,path));
    path.forEach( (i -> System.out.println(i[0] + "," + i[1])) );
  }

  private static boolean findPath( int[][] maze,int row,int col,List<Integer[]> path  )
  {
    if(row==maze.length-1 && col==maze[0].length-1)
    {
      path.add( new Integer[]{row,col} );
      return true;
    }
    else if( row== maze.length || col==maze[0].length)
    {
      return false;
    }
    boolean flag=false;
    if( row< maze.length-1 && maze[row+1][col]==1)
    {
      flag=findPath( maze,row+1,col,path );
    }
    if(!flag)
    {
      if( col< maze[0].length-1 && maze[row][col+1]==1)
      {
        flag=findPath( maze,row,col+1,path );
      }
    }
    if(flag)
    {
      path.add( new Integer[]{row,col} );
    }
    return flag;
  }
}
