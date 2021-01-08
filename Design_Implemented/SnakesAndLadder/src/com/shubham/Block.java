package com.shubham;

public class Block
{
  private int x;
  private int y;
  private int number;

  public Block( int x_, int y_ )
  {
    x = x_;
    y = y_;
    number =  (10*x_) + y_+1;
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

  public int getNumber()
  {
    return number;
  }

}
