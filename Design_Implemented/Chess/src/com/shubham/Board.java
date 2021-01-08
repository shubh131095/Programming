package com.shubham;

public class Board
{
  Box[][] boxes;

  public Box[][] getBoxes()
  {
    return boxes;
  }

  public void setBoxes( Box[][] boxes_ )
  {
    boxes = boxes_;
  }

  public Box getSpecificBox(int i,int j)
  {
    return boxes[i][j];
  }
}
