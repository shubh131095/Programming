package java.com.shubham.Piece;

import java.com.shubham.Board;
import java.com.shubham.Box;

// A king can moves in any one direction to its neighbour
public class KingPiece extends Piece
{
  public KingPiece( Boolean isWhite )
  {
    super( isWhite );
  }

  @Override
  public boolean canMove( Board board, Box start, Box end )
  {

    if(!isUnderBoundary( start,end ) || isSameTeamPiece( start,end )) return false;
    int x = Math.abs(end.getX() - start.getX());
    int y = Math.abs(end.getY() - start.getY());

    //x-y = 1 for immediate neighbour
    //x-y=0 for immediate diagonal
    if( (x-y)==1 || (x-y)==0)
    {
      return true;
    }
    return false;
  }
}
