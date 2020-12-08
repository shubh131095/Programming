package backtracking;
// in this problem you have given a matrix of size n*n . you can start fro any where
// you have a knight at strating position and you have to cover each node eactly once.
// contsraints the movement is based on knights movement in chess.

import java.util.Arrays;

// vriation can be made like give path and all.
public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 8; // size of matrix;
    int [][] board = new int[n][n]; // we can store soln here
    // marking all the nodes as unvisited
    for( int[] row : board)
    {
      Arrays.fill(row,-1);
    }
    // since for every cell the max movement can be 8 combinations
    // to understand how we created this both array.
    // consider a index (4,4) now from this index the 8 combination we can go it ( try to visualize it)
    // (i+2,j-1) (i+2,j+1) , (i-1,j+2) (i+1,j+2)  same 4 more comb.
    // so every i,j comb is identitical.
    // so all the increment in current positon are marked in the index
    // so xMove[0] and yMove[0] can be infered as this (i+2,j+1) like wise other.
    int[] xMove = {2,1,2,-1,1,-2,-1,-2};
    int[] yMove = {1,2,-1,2,-2,1,-2,-1};
    board[0][0] = 1; // starting from this node.
    // starting position will be (0,0) and since we already visited (0,0), visited is 1.
    if( findTour(board,0,0,1,xMove,yMove))
    {
      System.out.println("way exist");
      // print soln array.
    }
    else
    {
      System.out.println("all path can't be reached from this starring node.");
    }
  }

  private static boolean findTour( int[][] board, int row, int col,int nodeVisited,int[] xMove,int[] yMove )
  {
    if(nodeVisited==(board.length*2))
    {
      return true;
    }

   for(int i=0;i<board.length;i++)
   {
    int newXMove = row + xMove[i];
     int newYMove = col + yMove[i];
     if( isPossible(newXMove,newYMove,board))
     {
       board[newXMove][newYMove] = nodeVisited;
       if(findTour( board,newXMove,newYMove,nodeVisited+1,xMove,yMove ))
         return true;
       else
         board[newXMove][newYMove] = -1;
     }
   }
   return false;
  }

  private static boolean isPossible( int row, int col, int[][] board )
  {
    if( row>=0 && row<=board.length-1 && col>=0 && col<=board.length-1 && board[row][col]==-1)
      return true;
    else
      return false;
  }
}
