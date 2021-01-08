package com.shubham.ticTacToe;

public class Box
{
  private int x;
  private int y;
  private Boolean isMarked;
  private Player player;

  public Box(int x_,int y_)
  {
    new Box( x_,y_,false,null );
  }
  public Box( int x_, int y_, Boolean isMarked_, Player player_ )
  {
    x = x_;
    y = y_;
    isMarked = isMarked_;
    player = player_;
  }

  public int getX()
  {
    return x;
  }

  public void setX( int x_ )
  {
    x = x_;
  }

  public int getY()
  {
    return y;
  }

  public void setY( int y_ )
  {
    y = y_;
  }

  public Boolean getMarked()
  {
    return isMarked;
  }

  public void setMarked( Boolean marked_ )
  {
    isMarked = marked_;
  }

  public Player getPlayer()
  {
    return player;
  }

  public void setPlayer( Player player_ )
  {
    player = player_;
  }
}
