package BasicImplementation.random;

import java.util.Arrays;

// given a position of knight and given a ending position. return the min no of moves it take to reach that position in chess.
// cant go out of borad, if not possible return -1
public class KnightMove
{
  final static int row = 8;
  final static int col= 8;
  static boolean [][] is_visited = new boolean[row][col];
  public static void main( String[] args )
  {


    int startx = 3;
    int starty = 3;
    int endx =7;
    int endy=5;
    int ans = getMinMoves(startx,starty,endx,endy);
    System.out.println(ans);
  }

  private static int getMinMoves( int startx, int starty, int endx, int endy )
  {
    if(startx < 0 || starty <0 || endx <0 || endy<0 || startx>7 || starty>7| endx >7 || endy>7)
    {
      return 0;
    }
    if( startx==endx && starty==endy)
    {
      return 1;
    }
    int count =Integer.MAX_VALUE;
    int min_count = Integer.MAX_VALUE;
    is_visited[startx][starty]=true;
    for(int i=startx-2;i<=startx+2;i++)
    {
      if( i>7 ||i<0 )
      {
        break;
      }
      for(int j=starty-2;j<=starty+2;j++)
      {
        if( j>7 || j<0)
        {
          break;
        }

        if(!is_visited[i][j] && isValidMove(startx,starty,i,j)  )
        {
          count = getMinMoves(i,j,endx,endy )+1;
        }
      }
      min_count = Math.min( min_count,count );
    }
    is_visited[startx][starty]= false;
    return min_count;
  }

  private static boolean isValidMove( int startx, int starty, int endx, int endy )
  {
    if( endx>7 || endy>7 || endy<0 || endx<0)
    {
      return false;
    }
    int cumx = Math.abs(endx-startx);
    int cumy = Math.abs(endy-starty);
    if( cumy*cumx ==2) return true;
    else return false;
  }
}
