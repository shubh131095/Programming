package java.com.shubham.Piece;

import java.com.shubham.Board;
import java.com.shubham.Box;

// Its Move has 2 steps
// 1. can move only ahead
//2. can move diagonal one step only if he can kill.

// in original its has quite more restictions,like it can move 2 steps sometimes,sometimes not.
// we are keeping it simple in this.
// im also assuming black will start below and white will start above.
public class PawnPiece extends Piece
{
  public PawnPiece( Boolean isWhite )
  {
    super( isWhite );
  }

  @Override
  public boolean canMove( Board board, Box start, Box end )
  {
    if(!isUnderBoundary( start,end ) || isSameTeamPiece( start,end )) return false;

    // since white is starting from above,it can go down only.

    if(start.getPiece().isWhite())
    {
      if( (end.getY() == start.getY()) && ( (end.getX()-start.getX())==1))
      {
        return true;
      }
     if( (end.getX() == (start.getX()+1)) && ( end.getY() == (start.getY()-1) || end.getY() == (start.getY()+1)  ))
     {
       if( end.getPiece()!=null)
       {
         return  true;
       }
      else
       {
         return false;
       }
     }
    }
    else
    {
      // since bloack is starting from down,it can go up only.
      if( (end.getY() == start.getY()) && ( (start.getX()-end.getX())==1))
      {
        return true;
      }
      if( (end.getX() == (start.getX()-1)) && ( end.getY() == (start.getY()-1) || end.getY() == (start.getY()+1)  ))
      {
        if( end.getPiece()!=null)
        {
          return  true;
        }
        else
        {
          return false;
        }
      }
    }
    return false;
  }
}
