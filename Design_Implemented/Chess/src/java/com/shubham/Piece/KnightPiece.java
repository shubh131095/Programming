package java.com.shubham.Piece;

import java.com.shubham.Board;
import java.com.shubham.Box;

// Basically Horse
// can we move 2 steps and one counter steps
public class KnightPiece extends Piece
{
  public KnightPiece( Boolean isWhite )
  {
    super( isWhite );
  }

  @Override
  public boolean canMove( Board board, Box start, Box end )
  {

    if(!isUnderBoundary( start,end ) || isSameTeamPiece( start,end )) return false;

    int x = Math.abs(end.getX() - start.getX());
    int y = Math.abs(end.getY() - start.getY());

    // just draw a table of all possbile index where it can go from current by taking an example
    // you will get the idea
    if( x*y ==2)
    {
      return true;
    }
    return false;
  }
}
