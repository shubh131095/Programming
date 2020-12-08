package java.com.shubham;

import java.com.shubham.Piece.Piece;

public class Box
{
  Piece piece;
  Integer x;
  Integer y;

  public Box( Piece piece_,int x,int y )
  {
    piece = piece_;
    this.x=x;
    this.y=y;
  }

  public Piece getPiece()
  {
    return piece;
  }

  public void setPiece( Piece piece_ )
  {
    piece = piece_;
  }

  public Integer getX()
  {
    return x;
  }

  public void setX( Integer x_ )
  {
    x = x_;
  }

  public Integer getY()
  {
    return y;
  }

  public void setY( Integer y_ )
  {
    y = y_;
  }
}
