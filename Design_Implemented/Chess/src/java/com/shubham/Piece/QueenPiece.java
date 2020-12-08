package java.com.shubham.Piece;

import java.com.shubham.Board;
import java.com.shubham.Box;

// queen can basically move like bishop(camel) and elephant(rook) combined
public class QueenPiece extends Piece
{
  public QueenPiece( Boolean isWhite )
  {
    super( isWhite );
  }

  @Override
  public boolean canMove( Board board, Box start, Box end )
  {

    if(!isUnderBoundary( start,end ) || isSameTeamPiece( start,end )) return false;

    CamelPiece cmlMove = new CamelPiece( start.getPiece().isWhite() );
    ElephantPiece eleMove = new ElephantPiece( start.getPiece().isWhite()  );

    return cmlMove.canMove( board,start,end ) || eleMove.canMove( board,start,end );

  }
}
