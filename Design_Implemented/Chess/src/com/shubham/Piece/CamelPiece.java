package com.shubham.Piece;

import com.shubham.Board;
import com.shubham.Box;

// basically called bishop
// can only move diagonally in all direction.
public class CamelPiece extends Piece
{
  public CamelPiece( Boolean isWhite )
  {
    super( isWhite );
  }

  @Override
  public boolean canMove( Board board, Box start, Box end )
  {

    if(!isUnderBoundary( start,end ) || isSameTeamPiece( start,end )) return false;

    // here it can do to destination if no sameTeam or opponent team peice are present in path
    // 4 cases
      // 1. both i and j are reducing - upper left diagonal
      // 2. both i and j are incr - lower right diagonal
      // 3. i red and j inc -> upper right dia
      // 4. i inc and j red -> lower left dia.

    int startX = start.getX();
    int endX = end.getX();
    int startY= start.getY();
    int endY = end.getY();

    if( (endX > startX) && (endY>startY))
    {
      for( int i=startX+1,j=startY+1;i<endX&&j<startY;i++,j++)
      {
        Box curr = board.getSpecificBox(i,j);
        if(curr!=null)
        {
          return false;
        }
      }
      return true;
    }
    else if( (endX < startX) && (endY < startY) )
    {
      for( int i=startX-1,j=startY-1;i>endX&&j>startY;i--,j--)
      {
        Box curr = board.getSpecificBox(i,j);
        if(curr!=null)
        {
          return false;
        }
      }
      return true;
    }
    else if( (endX < startX) && (endY>startY))
    {
      for( int i=startX-1,j=startY+1;i>endX&&j<startY;i--,j++)
      {
        Box curr = board.getSpecificBox(i,j);
        if(curr!=null)
        {
          return false;
        }
      }
      return true;
    }
    else if( (endX < startX) && (endY > startY) )
    {
      for( int i=startX+1,j=startY-1;i<endX&&j>startY;i++,j--)
      {
        Box curr = board.getSpecificBox(i,j);
        if(curr!=null)
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
