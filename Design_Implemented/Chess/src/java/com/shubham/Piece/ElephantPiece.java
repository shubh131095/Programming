package java.com.shubham.Piece;

import java.com.shubham.Board;
import java.com.shubham.Box;

// offically known as rook.
// its movement is also just like bishop/camel only horizonatal/vertical
public class ElephantPiece extends Piece
{
  public ElephantPiece( Boolean isWhite )
  {
    super( isWhite );
  }

  @Override
  public boolean canMove( Board board, Box start, Box end )
  {
    if(!isUnderBoundary( start,end ) || isSameTeamPiece( start,end )) return false;

    // horizontal move
    int x = start.getX()-end.getX();
    int y = start.getY()-end.getY();
    if( x==0)
    {
      if(y>0)
      {
       for(int i= start.getY()-1;i>end.getY();i--)
       {
         Box curr = board.getSpecificBox(start.getX(),i  );
         if(curr!=null)
         {
           return false;
         }
       }
       return true;
      }
      else
      {
        for(int i= start.getY()+1;i<end.getY();i++)
        {
          Box curr = board.getSpecificBox(start.getX(),i  );
          if(curr!=null)
          {
            return false;
          }
        }
        return true;
      }
    }
    // vertical move
    if( y==0)
    {
      if(x>0)
      {
        for(int i= start.getX()-1;i>end.getX();i++)
        {
          Box curr = board.getSpecificBox(i,start.getY() );
          if(curr!=null)
          {
            return false;
          }
        }
        return true;
      }
      else
      {
        for(int i= start.getX()+1;i<end.getX();i++)
        {
          Box curr = board.getSpecificBox(i,start.getY()  );
          if(curr!=null)
          {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
}
