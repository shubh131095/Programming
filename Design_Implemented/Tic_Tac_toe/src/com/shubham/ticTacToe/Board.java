package com.shubham.ticTacToe;

public class Board
{
  Box[][] box;
  private int size;
    private int boxLeft;
  public Board( int size_ )
  {
    box = new Box[size_][size_];
    for(int i=0;i<size_;i++)
    {
      for(int j=0;j<size_;j++)
      {
        box[i][j] = new Box( i,j );
      }
    }
    size = size_;
    boxLeft = size_*size_;
  }

  public int getBoxLeft()
  {
    return boxLeft;
  }

  public void setBoxLeft( int boxLeft_ )
  {
    boxLeft = boxLeft_;
  }

  public int getSize()
  {
    return size;
  }

}
