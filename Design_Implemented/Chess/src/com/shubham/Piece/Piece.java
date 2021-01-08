package com.shubham.Piece;

import com.shubham.Board;
import com.shubham.Box;

public abstract class Piece
{
  private boolean isWhite;


  public Piece(Boolean isWhite)
  {
     this.isWhite=isWhite;
  }
  public boolean isWhite()
  {
    return isWhite;
  }

  // if move is beyond the box size,not a valid move
  public boolean isUnderBoundary(Box start,Box end)
  {
    if( end.getX()>7 || end.getY()>7 || end.getX()<0 || end.getY()<0 || start.getX()>7 || start.getY()>7 || start.getX()<0 || start.getY()<0)
      return false;
    else
      return true;
  }
  // if the destination box contain same player piece,not a valid move
  public boolean isSameTeamPiece(Box start,Box end)
  {
    if(end.getPiece().isWhite() == start.getPiece().isWhite())
      return false;
    else
      return true;
  }
  abstract public boolean canMove( Board board, Box start, Box end);
}
