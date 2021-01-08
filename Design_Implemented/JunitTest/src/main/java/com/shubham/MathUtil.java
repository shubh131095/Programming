package com.shubham;

public class MathUtil
{
  public int a;
  public int b;

  public MathUtil( int a_, int b_ )
  {
    a = a_;
    b = b_;
  }

  public int addNum( int a, int b)
  {
    return a+b;
  }
  public int addNum()
  {
    return this.a+this.b;
  }
}
